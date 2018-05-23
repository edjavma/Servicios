package gt.software.utils;

public class APDU {
	
	  public final static byte BYTE_PHOTO_DIR = (byte) 0x82;
	  
	//00 A4 04 0C 07 A0 00 00 02 47 10 01
	  public final static byte[] CMD_START = {
	    (byte) 0x00, (byte) 0xa4, (byte) 0x04, (byte) 0x0C, (byte) 0x07,
	    (byte) 0xA0, (byte) 0x00, (byte) 0x00, (byte) 0x02, (byte) 0x47, (byte) 0x10, (byte) 0x01
	  };

    
    //00 A4 04 0C 10 A0 00 00 00 77 01 83 83 08 10 00 F1 00 00 00 01 00
 // Start Card
 public final static byte[] CMD_01 = {
   (byte) 0x00, (byte) 0xA4, (byte) 0x04, (byte) 0x0C, (byte) 0x10,
   (byte) 0xA0, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x77, (byte) 0x01, (byte) 0x83, (byte) 0x83, (byte) 0x08, (byte) 0x10, (byte) 0x00, (byte) 0xF1, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x01, (byte) 0x00
 };

 //00 A4 00 00 02 3F 00 00
 // Maybe get Files or get datas
 public final static byte[] CMD_02 = {
   (byte) 0x00, (byte) 0xA4, (byte) 0x00, (byte) 0x00, (byte) 0x02,
   (byte) 0x3F, (byte) 0x00, (byte) 0x00
 };

 //00 A4 00 00 02 10 01 00
 // Maybe get datas
 public final static byte[] CMD_03 = {
   (byte) 0x00, (byte) 0xA4, (byte) 0x00, (byte) 0x00, (byte) 0x02,
   (byte) 0x10, (byte) 0x01, (byte) 0x00
 };

 //00 A4 02 00 02 01 01 00
 // Maybe go to file 01
 public final static byte[] CMD_GO_FILE01 = {
   (byte) 0x00, (byte) 0xA4, (byte) 0x02, (byte) 0x00, (byte) 0x02,
   (byte) 0x01, (byte) 0x01, (byte) 0x00
 };

 //00 A4 02 00 02 01 02 00
 public final static byte[] CMD_GO_FILE02 = {
   (byte) 0x00, (byte) 0xA4, (byte) 0x02, (byte) 0x00, (byte) 0x02,
   (byte) 0x01, (byte) 0x02, (byte) 0x00
 };

 //00 B0 00 00 00
 // Get First block 256 KB
 public final static byte[] CMD_GET_DATA_01 = {
   (byte) 0x00, (byte) 0xB0, (byte) 0x00, (byte) 0x00, (byte) 0x00
 };

 //00 B0 00 FF 00
 // Get Second block 256 KB
 public final static byte[] CMD_GET_DATA_02 = {
   (byte) 0x00, (byte) 0xB0, (byte) 0x00, (byte) 0xFF, (byte) 0x00
 };
   
}
