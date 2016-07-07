package mypage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		mav.addObject("questionForm", new Question());
		return mav;
	}
	
	@RequestMapping(value="/createArticle", method = RequestMethod.GET)
	public ModelAndView createArticle(){
		ModelAndView mav = new ModelAndView("createArticle");
		mav.addObject("article", new Article());
		return mav;
	}
	
	@RequestMapping(value="/articleCreation.do", method = RequestMethod.POST)
	public ModelAndView articleCreation(@ModelAttribute("article") Article article){
		ModelAndView mav = new ModelAndView("indexPost");
		article.setCreatedDate(new Date());
		article.setModifiedDate(new Date());
		homePageService.createArticle(article);
		return mav;
	}
	
	@RequestMapping(value="/postQuestion.do", method = RequestMethod.POST)
	public ModelAndView postQuestion(@ModelAttribute("questionForm") Question question){
		ModelAndView mav = new ModelAndView("indexPost");
		question.setDateCreated(new Date());
		homePageService.postQuestion(question);
		return mav;
	}
	
	public void setHomePageService(HomePageService homePageService) {
		this.homePageService = homePageService;
	}
}
