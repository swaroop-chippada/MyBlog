package mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mypage.domain.Article;
import mypage.domain.ArticleVO;
import mypage.domain.SearchVO;
import mypage.service.ArticlePageService;
import mypage.utils.WebConstants;

@RestController
public class RestArticleController {

	@Autowired
	private ArticlePageService articlePageService;

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

	@RequestMapping(value = "/ajax/article", method = RequestMethod.GET)
	public Article article(@RequestParam(value = "id", required = true) String articleId) {
		return articlePageService.getArticle(articleId);
	}

	@RequestMapping(value = "/ajax/search", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ArticleVO search(@RequestBody SearchVO searchVO) {
		int pageNo = StringUtils.isEmpty(searchVO.getOffset()) ? 0 : searchVO.getOffset();
		int pageSize = (searchVO.getSize() != 0) ? searchVO.getSize() : WebConstants.PAGE_SIZE;
		ArticleVO vo = new ArticleVO();
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

	public void setArticlePageService(ArticlePageService articlePageService) {
		this.articlePageService = articlePageService;
	}

}
