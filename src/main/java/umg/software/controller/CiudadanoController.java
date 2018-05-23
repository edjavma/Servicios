package umg.software.controller;

import java.util.List;

import javax.smartcardio.CardTerminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import gt.software.data.Dpi;
import umg.software.service.DpiService;

@RestController
@RequestMapping(value = "/dpi")
public class CiudadanoController {

	
	@Autowired
	private DpiService dpiService;
	
	@RequestMapping(value = "/read", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Dpi readDataDpi(@RequestParam("terminal") int terminal) {
		try {			
			Dpi dpi = dpiService.getInfoDpi(terminal);
			//dpi.setPhoto(dpiService.getPhoto(terminal));
			return dpi;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/list/terminals", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CardTerminal> listTerminals(){
		return dpiService.listTerminals();
	}
	
	
}
