package gt.software.utils;

import javax.smartcardio.CommandAPDU;

public class Command {
	
	public static CommandAPDU command(byte[] apdu) {
		CommandAPDU commandApdu = new CommandAPDU(apdu);
		return commandApdu;
	}

}
