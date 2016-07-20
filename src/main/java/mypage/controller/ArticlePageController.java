package mypage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.Article;
import mypage.service.HomePageService;
import mypage.utils.WebConstants;

@Controller
public class ArticlePageController {

	@Autowired
	private HomePageService homePageService;

	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public ModelAndView tagSearch(@RequestParam(value = "id", required = true) String tag,
			@RequestParam(value = "offset", required = false) String offset) {
		String viewName = "articleChannel";
		if ("news".equalsIgnoreCase(tag)) {
			viewName = "techNews";
		}
		
		ModelAndView mav = new ModelAndView(viewName );
		int pageNo;
		if (StringUtils.isEmpty(offset)) {
			pageNo = 0;
		} else {
			pageNo = Integer.parseInt(offset);
		}
		mav.addObject("articleList",
				homePageService.getArticlesForTag(pageNo * WebConstants.PAGE_SIZE, WebConstants.PAGE_SIZE, tag));
		mav.addObject("offset", pageNo);
		mav.addObject("tag", tag);
		long totalResults = homePageService.getArticlesCount(tag);
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
				homePageService.getSearchResults(pageNo * WebConstants.PAGE_SIZE, WebConstants.PAGE_SIZE, query));
		mav.addObject("offset", pageNo);
		mav.addObject("query", query);
		long totalResults = homePageService.getSearchResultsCount(query);
		pagination(mav, pageNo, totalResults);
		return mav;
	}

	private void pagination(ModelAndView mav, int pageNo, long totalResults) {
		int totalPages = (int) Math.ceil(totalResults / WebConstants.PAGE_SIZE);
		if (!(pageNo < totalPages)) {
			mav.addObject("next", true);
		}
		if (pageNo == 0) {
			mav.addObject("previous", true);
		}
	}

	@RequestMapping(value = "/*article.html", method = RequestMethod.GET)
	public ModelAndView article(@RequestParam("articleId") String id) {
		ModelAndView mav = new ModelAndView("article");
		mav.addObject("article", homePageService.getArticle(id));
		return mav;
	}

	@RequestMapping(value = "/createArticle", method = RequestMethod.GET)
	public ModelAndView createArticle() {
		ModelAndView mav = new ModelAndView("createArticle");
		mav.addObject("article", new Article());
		return mav;
	}

	@RequestMapping(value = "/articleCreation.do", method = RequestMethod.POST)
	public ModelAndView articleCreation(@ModelAttribute("article") Article article) {
		ModelAndView mav = new ModelAndView("index");
		article.setCreatedDate(new Date());
		article.setModifiedDate(new Date());
		homePageService.createArticle(article);
		mav.addObject("articleList", homePageService.getRecentArticles(0, WebConstants.PAGE_SIZE));
		mav.addObject("articleCreated", true);
		return mav;
	}

	public void setHomePageService(HomePageService homePageService) {
		this.homePageService = homePageService;
	}

}
