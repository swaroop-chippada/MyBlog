package mypage.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mypage.domain.Article;

@Repository
public class ArticleDAO {
	
	Datastore dataStore;
	
	public void createArticle(Article article) {
		dataStore.save(article);
	}

	public List<Article> getRecentArticles(int offset, int limit) {
		QueryResults<Article> article = dataStore.find(Article.class).order("-modifiedDate").offset(offset)
				.limit(limit);
		return article.asList();
	}

	public List<Article> getArticles(int offset, int limit, String tag) {
		QueryResults<Article> article = dataStore.find(Article.class).filter("tags", tag).order("-publicationDate")
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
	
	public Long getArticleUsingFeedLink(String feedLink) {
		return dataStore.find(Article.class, "feedDetails.feedLink", feedLink).countAll();
	}
	
	@Autowired
	public void setDataStoreTemplate(DataStoreTemplate dataStoreTemplate) {
		dataStore = dataStoreTemplate.getDataStore();
	}
}
