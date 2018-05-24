package umg.software.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import umg.software.entity.Ciudadano;
import umg.software.entity.Servicio;
import umg.software.service.CollectionService;
import umg.software.service.ServicioService;
import umg.software.utils.ResponseData;

@RestController
@RequestMapping(value = "/ciudadano")
public class ServiciosController {
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private ServicioService servicioService;

	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Ciudadano> findAllCiudadanos(){
		return collectionService.findAll();
	}
	
	@RequestMapping(value = "/crear", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData createObject(@RequestBody Ciudadano data) {
		ResponseData response = new ResponseData();
			System.out.println(data.toString());
			collectionService.crearCiudadano(data);
			response.setCode(200);
			response.setMessage("Guardado");
		return response;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Ciudadano> findByName(@RequestParam Object data) {
		//return collectionService.findByNameAge(name, age);
		try {
			System.out.println(data.toString());
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = new HashMap<String, Object>();
			
			map = mapper.readValue(data.toString(), new TypeReference<Map<String, Object>>(){});
			
			System.out.println(map);
			
			return collectionService.findMatch(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	@RequestMapping(value = "/find/dpi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Ciudadano findByName(@RequestParam("dpi") String dpi) {
		//return collectionService.findByNameAge(name, age);
		try {
			
			return collectionService.findByDpi(dpi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/servicios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Servicio> findServicios(){
		return servicioService.findAll();
	}
}
