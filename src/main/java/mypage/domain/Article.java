package mypage.domain;

import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Transient;
import org.mongodb.morphia.utils.IndexType;
import org.springframework.util.StringUtils;

@Entity("Article")
@Indexes(@Index(fields = @Field(value = "content", type = IndexType.TEXT) ))
public class Article {

	@Id
	private String id;
	private String heading;
	private String content;
	private String userId;
	@Transient
	private String category;
	private String imageUrl;
	private String[] tags;
	private Date createdDate;
	private Date modifiedDate;
	private Date publicationDate;
	private String articleUrl;
	private Long status;

	@Embedded
	private FeedDetails feedDetails;

	public FeedDetails getFeedDetails() {
		return feedDetails;
	}

	public void setFeedDetails(FeedDetails feedDetails) {
		this.feedDetails = feedDetails;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategory() {
		if (this.tags != null && this.tags.length > 0) {
			category = StringUtils.arrayToCommaDelimitedString(tags);
		}
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
		if (!StringUtils.isEmpty(category)) {
			tags = category.split(",");
		}
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getRelativeUrl() {
		return this.articleUrl + "/article-" + this.id + ".html";
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	

}
