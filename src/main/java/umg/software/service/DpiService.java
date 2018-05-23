package umg.software.service;

import java.util.ArrayList;
import java.util.List;

import javax.smartcardio.CardTerminal;

import org.springframework.stereotype.Service;

import gt.software.conexion.SmartCardConexion;
import gt.software.conexion.SmartCardConexionFactory;
import gt.software.conexion.SmartCardConexionImpl;
import gt.software.data.Dpi;

public interface DpiService {
	public byte[] getPhoto(int terminal);
	public Dpi getInfoDpi(int terminal);
	public List<CardTerminal> listTerminals();
}

@Service
class DpiServiceImpl implements DpiService{

	@Override
	public Dpi getInfoDpi(int terminal) {
		try {
			return SmartCardConexionFactory.connect(terminal);		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CardTerminal> listTerminals() {
		try {
			SmartCardConexion conexion = new SmartCardConexionImpl();
			return conexion.terminals();
		} catch (Exception e) {
			return new ArrayList<CardTerminal>();
		}
	}
	
	@Override
	public byte[] getPhoto(int terminal) {
		try {
			return null;
			//return SmartCardConexionFactory.readPhoto(terminal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
