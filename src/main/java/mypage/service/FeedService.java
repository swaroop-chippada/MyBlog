package mypage.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import mypage.domain.Article;
import mypage.utils.WebConstants;

@Service
public class FeedService {

	@Autowired
	private ArticlePageService articlePageService;

	public void ingestFeed(String feedUrl, String feedType, String feedProviderName) {
		URL url = null;
		try {
			url = new URL(feedUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SyndFeedInput input = new SyndFeedInput();
		try {
			SyndFeed feed = input.build(new XmlReader(url));
			System.out.println(feed);
			for (Object object : feed.getEntries()) {
				if (WebConstants.FEED_TYPE_RSS.equalsIgnoreCase(feedType) && object instanceof SyndEntry) {
					insertFeed((SyndEntry) object, feedProviderName);
				}
			}
		} catch (IllegalArgumentException | FeedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertFeed(SyndEntry syndEntry, String feedProviderName) {
		Article article = new Article();
		article.setFeedLink(syndEntry.getLink());
		article.setHeading(syndEntry.getTitle());
		article.setContent(syndEntry.getDescription().getValue());
		String[] tags = new String[syndEntry.getCategories().size() + 1];
		tags[0] = "news";
		int count = 1;
		for (Object cat : syndEntry.getCategories()) {
			tags[count] = cat.toString();
			count++;
		}
		article.setTags(tags);
		article.setUserId(syndEntry.getAuthor());
		List list = (ArrayList) syndEntry.getForeignMarkup();
		if (!list.isEmpty()) {
			Element element = (Element) list.get(0);
			article.setImageUrl(element != null ? element.getAttributeValue("url") : "");
		}
		article.setPublicationDate(syndEntry.getPublishedDate());
		article.setCreatedDate(new Date());
		article.setModifiedDate(new Date());
		article.setStatus(1L);
		article.setFromFeed(true);
		article.setFeedProviderName(feedProviderName);
		updateDescription(article);
		if (articlePageService.getArticleUsingFeedLink(article.getFeedLink()) == 0) {
			articlePageService.createArticle(article);
		}

	}

	/**
	 * Update the feed link to absolute url
	 * 
	 * @param article
	 */
	private void updateDescription(Article article) {
		Pattern p = Pattern.compile("href=\"(.*?)\"");
		Matcher m = p.matcher(article.getContent());
		String url = null;
		while (m.find()) {
			url = m.group(1);
			if (url.indexOf("#") > 0) {
				url = url.substring(0, url.indexOf("#"));
			}
			if (article.getFeedLink().contains(url)) {
				article.setContent(article.getContent().replaceAll(url, article.getFeedLink()));
				break;
			}
		}
	}

	public void setArticlePageService(ArticlePageService articlePageService) {
		this.articlePageService = articlePageService;
	}

}
