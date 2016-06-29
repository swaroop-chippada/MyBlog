package main.java.mypage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.java.mypage.domain.Question;
import main.java.mypage.service.HomePageService;

@Controller
public class HomePageController {

	@Autowired
	private HomePageService homePageService;


	@RequestMapping(value="/postQuestion.do", method = RequestMethod.POST)
	public ModelAndView postQuestion(){
		ModelAndView mav = new ModelAndView("blogs");
		Question q = new Question();
		q.setQuestion("is this a successfull test ?");
		q.setDateCreated(new Date());
		q.setUserName("testUser");
		homePageService.postQuestion(q);
		return mav;
	}

	public void setHomePageService(HomePageService homePageService) {
		this.homePageService = homePageService;
	}
}
