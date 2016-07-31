package mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RobotController {


	@RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
	public ModelAndView ingestFeedPage() {
		ModelAndView mav = new ModelAndView("robots");
		return mav;
	}
}
