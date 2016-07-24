package mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mypage.service.FeedService;

@Controller
public class FeedController {

	@Autowired
	private FeedService feedService;

	@RequestMapping(value = "/feed", method = RequestMethod.GET)
	public ModelAndView ingestFeedPage() {
		ModelAndView mav = new ModelAndView("ingestFeeds");
		return mav;
	}

	@RequestMapping(value = "/ingest", method = RequestMethod.POST)
	public @ResponseBody String ingestFeed(@RequestParam(value = "url", required = true) String url,
			@RequestParam(value = "feedType", required = true) String feedType) {
		feedService.ingestFeed(url, feedType);
		return "success";
	}

	public void setFeedService(FeedService feedService) {
		this.feedService = feedService;
	}

}
