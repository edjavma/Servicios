package gt.software.conexion;

import java.util.List;

import javax.smartcardio.ATR;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

public abstract interface SmartCardConexion {
	
	public List<CardTerminal> terminals () throws CardException;
	public ATR connect (int t, String protocol) throws CardException;
	public ResponseAPDU transmit (CommandAPDU apdu) throws CardException; 
	public void disconnect () throws CardException;

}
