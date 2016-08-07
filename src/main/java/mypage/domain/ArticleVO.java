package mypage.domain;

import java.io.Serializable;
import java.util.List;

public class ArticleVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5121428916515823173L;
	
	private List<Article> articles;
	private boolean previous;
	private boolean next;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public boolean isPrevious() {
		return previous;
	}

	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}