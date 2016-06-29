package main.java.mypage.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import main.java.mypage.domain.Question;

@Repository
public class GenericDAO {

	Datastore dataStore;

	public GenericDAO() {
		Morphia morphia = new Morphia();
		String dbName = "myproject";
		MongoClient mongoClient = new MongoClient(
				new MongoClientURI("mongodb://swapadmin:projectblog@ds017584.mlab.com:17584/myproject"));

		dataStore = morphia.createDatastore(mongoClient, dbName);
		morphia.mapPackage("main.java.mypage.domain");

	}
	
	public void postQuestion(Question question){
		dataStore.save(Question.class);
	}

	public List<Question> getQuestions() {
		QueryResults<Question> question = dataStore.find(Question.class);
		return question.asList();
	}
}
