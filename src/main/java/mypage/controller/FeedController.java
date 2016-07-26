package mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.FeedDetails;
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

	@RequestMapping(value = "/ingest", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String ingestFeed(@RequestBody FeedDetails feedDetails) {
		feedService.ingestFeed(feedDetails);
		return "success";
	}

	public void setFeedService(FeedService feedService) {
		this.feedService = feedService;
	}

}
