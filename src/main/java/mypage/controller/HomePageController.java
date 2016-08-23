package mypage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.Question;
import mypage.domain.User;
import mypage.domain.UserRole;
import mypage.service.CustomUserDetailsService;

@Controller
public class HomePageController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		return angularIndex();
	}

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView aboutMe(HttpServletResponse response) {
		try {
			response.sendRedirect("//#//aboutMe");
			response.setStatus(response.SC_MOVED_PERMANENTLY);
			return null;
		} catch (IOException e) {
			ModelAndView mav = new ModelAndView("aboutMe");
			mav.addObject("questionForm", new Question());
			return mav;
		}
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView angularIndex() {
		ModelAndView mav = new ModelAndView("angularIndex");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		mav.addObject("isUserLogged", !"anonymousUser".equalsIgnoreCase(auth.getName()));
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

	public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

}
