package umg.software.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umg.software.entity.Ciudadano;
import umg.software.repository.CollectionRepository;

public interface CollectionService {
	public List<Ciudadano> findAll();
	public List<Ciudadano> findMatch(Map<String, Object> params);
	public void crearCiudadano(Ciudadano ciudadano);
}

@Service
class CollectionServiceImpl implements CollectionService {
	
	@Autowired
	private CollectionRepository repo;

	@Override
	public List<Ciudadano> findAll() {
		try {
			return repo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Ciudadano>();
		}
	}
	
	public List<Ciudadano> findMatch(Map<String, Object> params) {
		try {
			
			List<Ciudadano> find = repo.findMatch(params);
			return find;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public void crearCiudadano(Ciudadano ciudadano) {
		repo.save(ciudadano);
	}
	
	

}
