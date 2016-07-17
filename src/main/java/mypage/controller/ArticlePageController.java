package mypage.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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
	public ModelAndView categoryPage(@RequestParam(value="id",required=true) String tag, @RequestParam(value="offset",required=false) String offset) {
		ModelAndView mav = new ModelAndView("articleChannel");
		int pageNo;
		if (StringUtils.isEmpty(offset)) {
			pageNo = 0;
		} else {
			pageNo = Integer.parseInt(offset);
		}
		mav.addObject("articleList", homePageService.getArticles(pageNo, WebConstants.PAGE_SIZE, tag));
		mav.addObject("offset", pageNo);
		mav.addObject("category", tag);
		pagination(mav, tag, pageNo);
		return mav;
	}

	private void pagination(ModelAndView mav, String tag, int pageNo) {
		long totalResults = homePageService.getArticlesCount(tag);
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
		Map<String, String> articleCategories = new LinkedHashMap<String, String>();
		articleCategories.put("java", "Java");
		articleCategories.put("spring", "Spring");
		articleCategories.put("hibernate", "Hibernate");
		articleCategories.put("solr", "Solr");
		articleCategories.put("angular", "Angular JS");
		articleCategories.put("mongo", "Mongo DB");
		articleCategories.put("others", "Others");
		mav.addObject("articleCategories", articleCategories);
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
