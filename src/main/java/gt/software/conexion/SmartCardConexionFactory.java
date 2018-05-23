package gt.software.conexion;

import javax.smartcardio.CardException;
import javax.smartcardio.ResponseAPDU;

import gt.software.data.Dpi;
import gt.software.utils.APDU;
import gt.software.utils.ByteConvert;
import gt.software.utils.Command;

public class SmartCardConexionFactory {
	
	 private static ResponseAPDU response;
	 private static String data01,data02,data03,data04;
	
	
	public static Dpi connect(int terminal) throws CardException {
		Dpi dpi = new Dpi();
		SmartCardConexion conexion = new SmartCardConexionImpl();
		conexion.connect(terminal, "*");
		conexion.transmit(Command.command(APDU.CMD_01));
		conexion.transmit(Command.command(APDU.CMD_02));
		conexion.transmit(Command.command(APDU.CMD_03));        
		conexion.transmit(Command.command(APDU.CMD_GO_FILE01));
        
        response = conexion.transmit(Command.command(APDU.CMD_GET_DATA_01));
        data01 = ByteConvert.byteToASCII(response.getBytes());
        
        response = conexion.transmit(Command.command(APDU.CMD_GET_DATA_02));
        data02 = ByteConvert.byteToASCII(response.getBytes());
        
        conexion.transmit(Command.command(APDU.CMD_GO_FILE02));
        response = conexion.transmit(Command.command(APDU.CMD_GET_DATA_01));
        data03 = ByteConvert.byteToASCII(response.getBytes());
        
        response = conexion.transmit(Command.command(APDU.CMD_GET_DATA_02));
        data04 = ByteConvert.byteToASCII(response.getBytes());
        
        dpi = new Dpi();
        dpi.setDatos(data01, data02, data03, data04);
        
        dpi.setPhoto(SmartCardConexionFactory.readPhoto(terminal, conexion));
		return dpi;
	}
	
	public static byte[] readPhoto(int terminal, SmartCardConexion conexion) throws CardException {
	    byte[] x;
	    byte size[] = new byte[2];
	    byte data[];
	    byte photo[] = null;
	    int BUFFER_SIZE = 256;
	    int OFFSET_PHOTO = 104;

	    Byte dir    = APDU.BYTE_PHOTO_DIR;
	    Byte offset = Byte.valueOf((byte) 0x00);

	    int photo_length;
	    int photo_residuo;

	    try {

	        conexion.transmit(Command.command(APDU.CMD_START));

	        // read bytes
	        x = readData(conexion, dir, offset, (byte) 0x00 );

	        // Busca el size.
	        size[0] = x[2];
	        size[1] = x[3];
	        photo_length = ByteConvert.byteToInteger(size) + 4;
	        photo_residuo = photo_length % BUFFER_SIZE;
	        data = new byte[photo_length];

	        // Start to put the bytes of the photo in the var data
	        System.arraycopy(x, 0, data, 0, BUFFER_SIZE);
	        for (int i = 1; i < (photo_length / BUFFER_SIZE); i++) {
	          x = readData(conexion, (byte) i, (byte) 0x00, (byte) 0x00);
	          System.arraycopy(x, 0, data, i * BUFFER_SIZE, BUFFER_SIZE);
	        }

	        if (photo_residuo > 0) {
	          x = readData(conexion, (byte) (photo_length / BUFFER_SIZE), (byte) 0x00, (byte) (photo_residuo));
	          System.arraycopy(x, 0, data, photo_length - photo_residuo, photo_residuo);
	        }

	        // copy in variable photo the real jpeg value of the data, it quits the first
	        // OFFSET_PHOTO bytes, because meta info.
	        photo = new byte[photo_length - OFFSET_PHOTO];
	        System.arraycopy(data, OFFSET_PHOTO, photo, 0, photo_length - OFFSET_PHOTO);
	      return photo;
	    }
	    catch (CardException ex) {
	      throw new CardException(ex);
	    }
	  }
	
	private static byte[] readData(SmartCardConexion conexion, byte direction, byte offset, byte length) throws CardException {
	    byte x[] = null;

	    byte sendBytes[] = {
	      (byte) 0x00, (byte) 0xB0, direction, offset, (byte) length
	    };

	    

	    ResponseAPDU response;
	    try {
	      response = conexion.transmit(Command.command(sendBytes));
	 
	        x = response.getBytes();
	        //logger.debug("Reading bytes: " + arrayToHex(x));

	    }
	    catch (CardException ex) {
	      //logger.error("Error in readData", ex);
	      throw new CardException(ex);
	    }
	    return x;
	  }

}
