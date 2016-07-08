package mypage.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import mypage.domain.Article;
import mypage.domain.Question;

@Repository
public class GenericDAO {

	Datastore dataStore;

	public GenericDAO() {
		Morphia morphia = new Morphia();
		String dbName = "myproject";
		MongoClient mongoClient = new MongoClient(
				new MongoClientURI("mongodb://swapadmin:projectblog@ds017584.mlab.com:17584/myproject"));

		dataStore = morphia.createDatastore(mongoClient, dbName);
		morphia.mapPackage("mypage.domain");

	}
	
	public void postQuestion(Question question){
		dataStore.save(question);
	}

	public List<Question> getQuestions() {
		QueryResults<Question> question = dataStore.find(Question.class);
		return question.asList();
	}

	public void createArticle(Article article) {
		dataStore.save(article);
	}
	
	public List<Article> getRecentArticles(int offset, int limit) {
		QueryResults<Article> article = dataStore.find(Article.class).order("-modifiedDate").offset(offset).limit(limit);
		return article.asList();
	}
	
	public Article getArticle(String id) {
		Query<Article> article = dataStore.find(Article.class, "id", new ObjectId(id));
		return article.get();
	}
}
