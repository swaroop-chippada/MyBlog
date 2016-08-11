package mypage.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mypage.domain.Question;

@Repository
public class HomePageDAO {
	
	Datastore dataStore;

	public void postQuestion(Question question) {
		dataStore.save(question);
	}

	public List<Question> getQuestions() {
		QueryResults<Question> question = dataStore.find(Question.class);
		return question.asList();
	}

	@Autowired
	public void setDataStoreTemplate(DataStoreTemplate dataStoreTemplate) {
		dataStore = dataStoreTemplate.getDataStore();
	}

}
