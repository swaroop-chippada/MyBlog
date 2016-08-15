package mypage.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.Article;
import mypage.service.ArticlePageService;
import mypage.utils.WebConstants;
import mypage.utils.WebUtils;

@Controller
public class ArticlePageController {

	@Autowired
	private ArticlePageService articlePageService;

	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public ModelAndView tagSearch(@RequestParam(value = "id", required = true) String tag,
			@RequestParam(value = "offset", required = false) String offset) {
		String viewName = "articleChannel";
		// if ("news".equalsIgnoreCase(tag)) {
		viewName = "techNews";
		// }

		ModelAndView mav = new ModelAndView(viewName);
		int pageNo;
		if (StringUtils.isEmpty(offset)) {
			pageNo = 0;
		} else {
			pageNo = Integer.parseInt(offset);
		}
		mav.addObject("articleList",
				articlePageService.getArticlesForTag(pageNo * WebConstants.PAGE_SIZE, WebConstants.PAGE_SIZE, tag));
		mav.addObject("offset", pageNo);
		mav.addObject("tag", tag);
		long totalResults = articlePageService.getArticlesCount(tag);
		pagination(mav, pageNo, totalResults);
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "query", required = true) String query,
			@RequestParam(value = "offset", required = false) String offset) {
		ModelAndView mav = new ModelAndView("searchResults");
		int pageNo;
		if (StringUtils.isEmpty(offset)) {
			pageNo = 0;
		} else {
			pageNo = Integer.parseInt(offset);
		}
		mav.addObject("articleList",
				articlePageService.getSearchResults(pageNo * WebConstants.PAGE_SIZE, WebConstants.PAGE_SIZE, query));
		mav.addObject("offset", pageNo);
		mav.addObject("query", query);
		long totalResults = articlePageService.getSearchResultsCount(query);
		pagination(mav, pageNo, totalResults);
		return mav;
	}

	@RequestMapping(value = "/*/article*.html", method = RequestMethod.GET)
	public ModelAndView article(HttpServletRequest request) {
		String articleId = WebUtils.getArticleId(request.getRequestURI());
		ModelAndView mav = new ModelAndView("article");
		mav.addObject("article", articlePageService.getArticle(articleId));
		return mav;
	}

	@RequestMapping(value = "/createArticle", method = RequestMethod.GET)
	public ModelAndView createArticle() {
		ModelAndView mav = new ModelAndView("createArticle");
		Article article = new Article();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		article.setUserId(auth.getName());
		mav.addObject("article", article);
		return mav;
	}

	@RequestMapping(value = "/articleCreation.do", method = RequestMethod.POST)
	public ModelAndView articleCreation(@ModelAttribute("article") Article article) {
		ModelAndView mav = new ModelAndView("createArticle");
		if (StringUtils.isEmpty(article.getId())) {
			article.setId(null);
			article.setCreatedDate(new Date());
			article.setModifiedDate(new Date());
			article.setPublicationDate(new Date());
			article.setStatus(1);
			article.setArticleUrl(WebUtils.convertToArticleUrl(article.getHeading()));
			articlePageService.createArticle(article);
			mav.addObject("articleCreated", true);
		} else {
			Article originalArticle = articlePageService.getArticle(article.getId());
			updateArticleChanges(originalArticle, article);
			articlePageService.createArticle(originalArticle);
			mav.addObject("articleUpdated", true);
		}

		mav.addObject("article", article);
		return mav;
	}

	private void updateArticleChanges(Article original, Article modified) {
		original.setHeading(modified.getHeading());
		original.setTags(modified.getTags());
		original.setContent(modified.getContent());
		original.setImageUrl(modified.getImageUrl());
		original.setUserId(modified.getUserId());
		original.setModifiedDate(new Date());
	}

	private void pagination(ModelAndView mav, int pageNo, long totalResults) {
		if (!((pageNo + 1) * WebConstants.PAGE_SIZE < totalResults)) {
			mav.addObject("next", true);
		}
		if (pageNo == 0) {
			mav.addObject("previous", true);
		}
	}

	public void setArticlePageService(ArticlePageService articlePageService) {
		this.articlePageService = articlePageService;
	}

}
