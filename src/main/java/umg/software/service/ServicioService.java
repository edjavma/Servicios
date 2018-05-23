package umg.software.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umg.software.entity.Servicio;
import umg.software.repository.ServicioRepository;

public interface ServicioService {
	public List<Servicio> findAll();
}

@Service
class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioRepository servicioRepo;
	
	@Override
	public List<Servicio> findAll() {
		try {
			return servicioRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
