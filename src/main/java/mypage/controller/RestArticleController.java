package mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.Article;
import mypage.domain.ArticleVO;
import mypage.domain.SearchVO;
import mypage.domain.User;
import mypage.domain.UserRole;
import mypage.service.ArticlePageService;
import mypage.service.CustomUserDetailsService;
import mypage.utils.WebConstants;

@RestController
public class RestArticleController {

	@Autowired
	private ArticlePageService articlePageService;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@RequestMapping(value = "/ajax/tag", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ArticleVO tagSearch(@RequestBody SearchVO searchVO) {
		int pageNo = StringUtils.isEmpty(searchVO.getOffset()) ? 0 : searchVO.getOffset();
		int pageSize = (searchVO.getSize() != 0) ? searchVO.getSize() : WebConstants.PAGE_SIZE;
		ArticleVO vo = new ArticleVO();
		vo.setArticles(articlePageService.getArticlesForTag(pageNo * pageSize, pageSize, searchVO.getTagId()));
		long totalResults = articlePageService.getArticlesCount(searchVO.getTagId());
		pagination(vo, pageNo, totalResults, pageSize);
		return vo;
	}

	@RequestMapping(value = "/ajax/allArticles", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ArticleVO getAllArticles(@RequestBody SearchVO searchVO) {
		int pageNo = StringUtils.isEmpty(searchVO.getOffset()) ? 0 : searchVO.getOffset();
		int pageSize = (searchVO.getSize() != 0) ? searchVO.getSize() : WebConstants.PAGE_SIZE;
		ArticleVO vo = new ArticleVO();
		vo.setArticles(articlePageService.getRecentArticles(pageNo * pageSize, pageSize));
		long totalResults = articlePageService.getRecentArticlesCount();
		pagination(vo, pageNo, totalResults, pageSize);
		return vo;
	}

	@RequestMapping(value = "/ajax/article", method = RequestMethod.GET)
	public Article article(@RequestParam(value = "id", required = true) String articleId) {
		return articlePageService.getArticle(articleId);
	}

	@RequestMapping(value = "/ajax/search", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ArticleVO search(@RequestBody SearchVO searchVO) {
		ArticleVO vo = new ArticleVO();
		if (StringUtils.isEmpty(searchVO.getSearchKey())) {
			return vo;
		}
		int pageNo = StringUtils.isEmpty(searchVO.getOffset()) ? 0 : searchVO.getOffset();
		int pageSize = (searchVO.getSize() != 0) ? searchVO.getSize() : WebConstants.PAGE_SIZE;
		vo.setArticles(articlePageService.getSearchResults(pageNo * pageSize, pageSize, searchVO.getSearchKey()));
		long totalResults = articlePageService.getSearchResultsCount(searchVO.getSearchKey());
		pagination(vo, pageNo, totalResults, pageSize);
		return vo;
	}

	private void pagination(ArticleVO vo, int pageNo, long totalResults, int pageSize) {
		if (!((pageNo + 1) * pageSize < totalResults)) {
			vo.setNext(true);
		}
		if (pageNo == 0) {
			vo.setPrevious(true);
		}
	}

	@RequestMapping(value = "/ajax/register", method = RequestMethod.POST)
	public boolean saveNewUser(@ModelAttribute("newUser") User user) {
		if (customUserDetailsService.getUserDetail(user.getUserName()) != null) {
			return false;
		} else {
			user.setRole(UserRole.ENDUSER);
			customUserDetailsService.saveNewUser(user);
		}
		return true;
	}

	public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	public void setArticlePageService(ArticlePageService articlePageService) {
		this.articlePageService = articlePageService;
	}

}
