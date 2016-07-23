package mypage.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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
		String host;
		if (!StringUtils.isEmpty(System.getenv("MONGODB_URI"))) {
			host = System.getenv("MONGODB_URI");
		} else {
			host = System.getProperty("MONGODB_URL");
		}

		MongoClient mongoClient = new MongoClient(new MongoClientURI(host));

		dataStore = morphia.createDatastore(mongoClient, dbName);
		morphia.mapPackage("mypage.domain");

	}

	public void postQuestion(Question question) {
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
		QueryResults<Article> article = dataStore.find(Article.class).order("-modifiedDate").offset(offset)
				.limit(limit);
		return article.asList();
	}

	public List<Article> getArticles(int offset, int limit, String tag) {
		QueryResults<Article> article = dataStore.find(Article.class).filter("tags", tag).order("-modifiedDate")
				.offset(offset).limit(limit);
		return article.asList();
	}

	public List<Article> getSearchResults(int offset, int limit, String query) {
		QueryResults<Article> article = dataStore.find(Article.class).search(query).offset(offset).limit(limit);
		return article.asList();
	}

	public long getArticlesCount(String tag) {
		return dataStore.find(Article.class).filter("tags", tag).countAll();
	}

	public long getSearchResultsCount(String query) {
		return dataStore.find(Article.class).search(query).countAll();
	}

	public Article getArticle(String id) {
		Query<Article> article = dataStore.find(Article.class, "id", new ObjectId(id));
		return article.get();
	}
}
