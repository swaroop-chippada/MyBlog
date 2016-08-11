package mypage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.Question;
import mypage.domain.User;
import mypage.domain.UserRole;
import mypage.service.ArticlePageService;
import mypage.service.CustomUserDetailsService;
import mypage.service.HomePageService;

@Controller
public class HomePageController {

	@Autowired
	private HomePageService homePageService;

	@Autowired
	private ArticlePageService articlePageService;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView("index");
		// Recent 5
		mav.addObject("articleList", articlePageService.getRecentArticles(0, 5));
		return mav;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		return indexPage();
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView aboutMe() {
		ModelAndView mav = new ModelAndView("aboutMe");
		mav.addObject("questionForm", new Question());
		return mav;
	}

	@RequestMapping(value = "/angularIndex", method = RequestMethod.GET)
	public ModelAndView angularIndex() {
		ModelAndView mav = new ModelAndView("angularIndex");
		return mav;
	}

	@RequestMapping(value = "/postQuestion.do", method = RequestMethod.POST)
	public ModelAndView postQuestion(@ModelAttribute("questionForm") Question question) {
		ModelAndView mav = new ModelAndView("aboutMe");
		question.setDateCreated(new Date());
		homePageService.postQuestion(question);
		mav.addObject("questionForm", new Question());
		mav.addObject("questionPosted", true);
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView saveNewUser(@ModelAttribute("newUser") User user) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("newUser", new User());
		if (customUserDetailsService.getUserDetail(user.getUserName()) != null) {
			mav.addObject("Message", "User Already exist! Choose a different UserName");
		} else {
			user.setRole(UserRole.ENDUSER);
			customUserDetailsService.saveNewUser(user);
			mav.addObject("Message", "Registered successfully !");
		}
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("newUser", new User());
		return mav;
	}

	public void setHomePageService(HomePageService homePageService) {
		this.homePageService = homePageService;
	}

	public void setArticlePageService(ArticlePageService articlePageService) {
		this.articlePageService = articlePageService;
	}

	public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

}
