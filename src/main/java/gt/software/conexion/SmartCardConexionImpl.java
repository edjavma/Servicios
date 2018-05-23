package gt.software.conexion;

import java.util.List;

import javax.smartcardio.ATR;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

public class SmartCardConexionImpl implements SmartCardConexion{
	
	private Card card;
	private CardChannel channel;
	
	public SmartCardConexionImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	@SuppressWarnings("static-access")
	public List<CardTerminal> terminals() throws CardException {
		  TerminalFactory factory = TerminalFactory.getDefault().getDefault();
	      return factory.terminals().list();
	}

	@Override
	public ATR connect(int t, String protocol) throws CardException {
		CardTerminal terminal = this.terminals().get(t);
	    card = terminal.connect(protocol);
	    card.beginExclusive();
	    channel = card.getBasicChannel();
	    return card.getATR();
	}

	@Override
	public ResponseAPDU transmit(CommandAPDU apdu) throws CardException {
		return channel.transmit(apdu);
	}

	@Override
	public void disconnect() throws CardException {
		card.endExclusive();
	    card.disconnect(true);
	}

}
