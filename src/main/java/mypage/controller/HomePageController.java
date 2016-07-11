package mypage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public ModelAndView aboutMe(){
		ModelAndView mav = new ModelAndView("aboutMe");
		mav.addObject("questionForm",new Question());
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
