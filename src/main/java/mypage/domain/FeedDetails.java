package mypage.domain;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Transient;

public class FeedDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6319821457896697238L;
	private String feedProviderName;
	private String feedLink;
	@Transient
	private String feedTags;
	@Transient
	private String feedType;
	@Transient
	private String feedUrl;

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	public String getFeedProviderName() {
		return feedProviderName;
	}

	public void setFeedProviderName(String feedProviderName) {
		this.feedProviderName = feedProviderName;
	}

	public String getFeedLink() {
		return feedLink;
	}

	public void setFeedLink(String feedLink) {
		this.feedLink = feedLink;
	}

	public String getFeedTags() {
		return feedTags;
	}

	public void setFeedTags(String feedTags) {
		this.feedTags = feedTags;
	}

	public String getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(String feedUrl) {
		this.feedUrl = feedUrl;
	}
}
