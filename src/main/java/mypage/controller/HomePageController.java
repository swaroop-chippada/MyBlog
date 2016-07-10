package mypage.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.Article;
import mypage.domain.Question;
import mypage.service.HomePageService;

@Controller
public class HomePageController {

	@Autowired
	private HomePageService homePageService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView indexPage(){
		ModelAndView mav = new ModelAndView("index");
		//Recent 5
		mav.addObject("articleList",homePageService.getRecentArticles(0, 5));
		return mav;
	}
	
	@RequestMapping(value="/Home", method = RequestMethod.GET)
	public ModelAndView homePage(){
		return indexPage();
	}
	
	@RequestMapping(value="/category", method = RequestMethod.GET)
	public ModelAndView categoryPage(@RequestParam("id") String category){
		ModelAndView mav = new ModelAndView("articleChannel");
		//Recent 5
		mav.addObject("articleList",homePageService.getRecentArticles(0, 5, category));
		return mav;
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public ModelAndView aboutMe(){
		ModelAndView mav = new ModelAndView("aboutMe");
		mav.addObject("questionForm",new Question());
		return mav;
	}
	
	@RequestMapping(value="/*article.html", method = RequestMethod.GET)
	public ModelAndView article(@RequestParam("articleId") String id){
		ModelAndView mav = new ModelAndView("article");
		mav.addObject("article", homePageService.getArticle(id));
		return mav;
	}
	
	@RequestMapping(value="/createArticle", method = RequestMethod.GET)
	public ModelAndView createArticle(){
		ModelAndView mav = new ModelAndView("createArticle");
		mav.addObject("article", new Article());
		Map<String,String> articleCategories = new LinkedHashMap<String,String>();
		articleCategories.put("java", "Java");
		articleCategories.put("spring", "Spring");
		articleCategories.put("hibernate", "Hibernate");
		articleCategories.put("solr", "Solr");
		mav.addObject("articleCategories", articleCategories);
		return mav;
	}
	
	@RequestMapping(value="/articleCreation.do", method = RequestMethod.POST)
	public ModelAndView articleCreation(@ModelAttribute("article") Article article){
		ModelAndView mav = new ModelAndView("index");
		article.setCreatedDate(new Date());
		article.setModifiedDate(new Date());
		homePageService.createArticle(article);
		mav.addObject("articleList",homePageService.getRecentArticles(0, 5));
		mav.addObject("articleCreated", true);
		return mav;
	}
	
	@RequestMapping(value="/postQuestion.do", method = RequestMethod.POST)
	public ModelAndView postQuestion(@ModelAttribute("questionForm") Question question){
		ModelAndView mav = new ModelAndView("aboutMe");
		question.setDateCreated(new Date());
		homePageService.postQuestion(question);
		mav.addObject("questionForm", new Question());
		mav.addObject("questionPosted", true);
		return mav;
	}
	
	public void setHomePageService(HomePageService homePageService) {
		this.homePageService = homePageService;
	}

}
