package umg.software.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import umg.software.entity.Ciudadano;
import umg.software.repositoryImpl.CollectionRepositoryCustom;


@Repository
public interface CollectionRepository extends MongoRepository<Ciudadano, String>, CollectionRepositoryCustom {

	

		
}
