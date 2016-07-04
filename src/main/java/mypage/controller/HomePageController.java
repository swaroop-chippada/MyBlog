package mypage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.Question;
import mypage.service.HomePageService;

@Controller
public class HomePageController {

	@Autowired
	private HomePageService homePageService;


	@RequestMapping(value="/postQuestion.do", method = RequestMethod.GET)
	public ModelAndView postQuestion(){
		System.out.println("postQuestion ---------");
		ModelAndView mav = new ModelAndView("blogs");
		Question q = new Question();
		q.setQuestion("is this a successfull test ?");
		q.setDateCreated(new Date());
		q.setUserName("testUser");
		homePageService.postQuestion(q);
		System.out.println("postQuestion --------- end");
		return mav;
	}
	
	@RequestMapping(value="/blogs.do", method = RequestMethod.GET)
	public ModelAndView blogs(){
		ModelAndView mav = new ModelAndView("blogs");
		mav.addObject("name","Swaroop");
		mav.addObject("title", "Welcome");
		return mav;
	}

	public void setHomePageService(HomePageService homePageService) {
		this.homePageService = homePageService;
	}
}
