package mypage.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypage.dao.GenericDAO;
import mypage.domain.Article;
import mypage.domain.Question;

@Service
public class HomePageService {

	@Autowired
	private GenericDAO genericDAO;

	public List<Question> getQuestions() {
		return genericDAO.getQuestions();
	}

	public void postQuestion(Question question) {
		genericDAO.postQuestion(question);
	}

	public void createArticle(Article article) {
		genericDAO.createArticle(article);
	}

	public List<Article> getRecentArticles(int offset, int limit) {
		return genericDAO.getRecentArticles(offset, limit);
	}

	public List<Article> getArticlesForTag(int offset, int limit, String tag) {
		return genericDAO.getArticles(offset, limit, tag);
	}
	
	public List<Article> getSearchResults(int offset, int limit, String query) {
		return genericDAO.getSearchResults(offset, limit, query);
	}
	
	public long getArticlesCount(String tag){
		return genericDAO.getArticlesCount(tag);
	}
	
	public long getSearchResultsCount(String query){
		return genericDAO.getSearchResultsCount(query);
	}

	public Article getArticle(String id) {
		return genericDAO.getArticle(id);
	}

	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

}
