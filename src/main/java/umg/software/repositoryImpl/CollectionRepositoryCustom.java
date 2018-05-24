package umg.software.repositoryImpl;

import java.util.List;
import java.util.Map;

import umg.software.entity.Ciudadano;

public interface CollectionRepositoryCustom {

	public List<Ciudadano> findMatch(Map<String, Object> params);
	public Ciudadano findByDpi(String dpi);
}
