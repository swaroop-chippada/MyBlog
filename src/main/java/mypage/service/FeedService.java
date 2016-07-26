package mypage.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import mypage.domain.Article;
import mypage.domain.FeedDetails;
import mypage.utils.WebConstants;
import mypage.utils.WebUtils;

@Service
public class FeedService {

	@Autowired
	private ArticlePageService articlePageService;

	public void ingestFeed(FeedDetails feedDetails) {
		URL url = null;
		try {
			url = new URL(feedDetails.getFeedUrl());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SyndFeedInput input = new SyndFeedInput();
		try {
			SyndFeed feed = input.build(new XmlReader(url));
			for (Object object : feed.getEntries()) {
				if (WebConstants.FEED_TYPE_RSS.equalsIgnoreCase(feedDetails.getFeedType())
						&& object instanceof SyndEntry) {
					insertFeed((SyndEntry) object, feedDetails);
				}
			}
		} catch (IllegalArgumentException | FeedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertFeed(SyndEntry syndEntry, FeedDetails feedDetails) {
		Article article = new Article();

		article.setHeading(syndEntry.getTitle());
		article.setContent(syndEntry.getDescription().getValue());

		List<String> listTags = new ArrayList<String>();
		for (String tag : feedDetails.getFeedTags().split(",")) {
			if (!StringUtils.isEmpty(tag))
				listTags.add(tag);
		}
		for (Object cat : syndEntry.getCategories()) {
			listTags.add(cat.toString());
		}
		String[] myArray = new String[listTags.size()];
		listTags.toArray(myArray);		
		article.setTags(myArray);
		article.setUserId(syndEntry.getAuthor());
		List list = (ArrayList) syndEntry.getForeignMarkup();
		if (!list.isEmpty()) {
			Element element = (Element) list.get(0);
			article.setImageUrl(element != null ? element.getAttributeValue("url") : "");
		}
		article.setArticleUrl(WebUtils.convertToArticleUrl(article.getHeading()));
		article.setPublicationDate(syndEntry.getPublishedDate());
		article.setCreatedDate(new Date());
		article.setModifiedDate(new Date());
		article.setStatus(1L);

		// Update Feed Details
		feedDetails.setFeedLink(syndEntry.getLink());
		article.setFeedDetails(feedDetails);

		// Update Description and inline image width
		updateDescription(article, syndEntry.getLink());

		// to avoid duplicate content, check if article exist using feedlink
		if (articlePageService.getArticleUsingFeedLink(feedDetails.getFeedLink()) == 0) {
			articlePageService.createArticle(article);
		}

	}

	/**
	 * Update the feed link to absolute url
	 * 
	 * @param article
	 */
	private void updateDescription(Article article, String feedLink) {
		Pattern p = Pattern.compile("href=\"(.*?)\"");
		Matcher m = p.matcher(article.getContent());
		String url = null;
		while (m.find()) {
			url = m.group(1);
			if (url.indexOf("#") > 0) {
				url = url.substring(0, url.indexOf("#"));
			}
			if (feedLink.contains(url)) {
				article.setContent(article.getContent().replaceAll(url, feedLink));
				break;
			}
		}
		// update image width to 100%
		article.setContent(article.getContent().replaceAll("<img", "<img width=\"100%\""));
	}

	public void setArticlePageService(ArticlePageService articlePageService) {
		this.articlePageService = articlePageService;
	}

}
