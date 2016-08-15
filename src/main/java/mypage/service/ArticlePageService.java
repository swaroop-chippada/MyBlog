package mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypage.dao.ArticleDAO;
import mypage.domain.Article;

@Service
public class ArticlePageService {

	@Autowired
	private ArticleDAO articleDAO;

	public void createArticle(Article article) {
		articleDAO.createArticle(article);
	}

	public List<Article> getRecentArticles(int offset, int limit) {
		return articleDAO.getRecentArticles(offset, limit);
	}
	
	public long getRecentArticlesCount() {
		return articleDAO.getRecentArticlesCount();
	}

	public List<Article> getArticlesForTag(int offset, int limit, String tag) {
		return articleDAO.getArticles(offset, limit, tag);
	}

	public List<Article> getSearchResults(int offset, int limit, String query) {
		return articleDAO.getSearchResults(offset, limit, query);
	}

	public long getArticlesCount(String tag) {
		return articleDAO.getArticlesCount(tag);
	}

	public long getSearchResultsCount(String query) {
		return articleDAO.getSearchResultsCount(query);
	}

	public Article getArticle(String id) {
		return articleDAO.getArticle(id);
	}
	
	public Long getArticleUsingFeedLink(String feedLink) {
		return articleDAO.getArticleUsingFeedLink(feedLink);
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

}
