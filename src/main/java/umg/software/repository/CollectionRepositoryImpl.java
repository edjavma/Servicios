package umg.software.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import umg.software.entity.Ciudadano;
import umg.software.repositoryImpl.CollectionRepositoryCustom;


public class CollectionRepositoryImpl implements CollectionRepositoryCustom {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Ciudadano> findMatch(Map<String, Object> params) {
		try {
			Query resultQuery = new Query();
			Criteria criteriaQuery = new Criteria();
			Iterator<Entry<String, Object>> it = params.entrySet().iterator(); 
			//resultQuery.addCriteria(Criteria.where("data.name").is(name).and("data.age").is(age));
			int count = 0;
			while(it.hasNext()) {
				Entry<String, Object> param = it.next();
				if(count == 0) {
					if(param.getValue().getClass() == String.class) {
						criteriaQuery = Criteria.where("data.".concat(param.getKey())).regex(param.getValue().toString(),"i");
					}else {
						criteriaQuery = Criteria.where("data.".concat(param.getKey())).is(param.getValue());
					}					
				}else {
					if(param.getValue().getClass() == String.class) {
						criteriaQuery = criteriaQuery.and("data.".concat(param.getKey())).regex(param.getValue().toString(),"i");
					}else {
						criteriaQuery = criteriaQuery.and("data.".concat(param.getKey())).is(param.getValue());
					}						
				}
				
				
				count++;
			}
			
			resultQuery.addCriteria(criteriaQuery);
			//Ciudadano result = mongoTemplate.findOne(resultQuery, Ciudadano.class);
			List<Ciudadano> result = mongoTemplate.find(resultQuery, Ciudadano.class);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Ciudadano findByDpi(String dpi) {
		try {
			Query resultQuery = new Query();
			resultQuery.addCriteria(Criteria.where("dpi").is(dpi));			
			Ciudadano result = mongoTemplate.findOne(resultQuery, Ciudadano.class);			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
