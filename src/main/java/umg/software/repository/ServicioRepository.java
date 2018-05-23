package umg.software.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import umg.software.entity.Servicio;

@Repository
public interface ServicioRepository extends MongoRepository<Servicio, String>{

}
