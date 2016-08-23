package mypage.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDAO {
	
	Datastore dataStore;

	public void postQuestion(Object entity) {
		dataStore.save(entity);
	}

	public <T> List<T> getQuestions(Class<T> entityClass) {
		QueryResults<T> question = dataStore.find(entityClass);
		return question.asList();
	}
	
	@Autowired
	public void setDataStoreTemplate(DataStoreTemplate dataStoreTemplate) {
		dataStore = dataStoreTemplate.getDataStore();
	}

}
