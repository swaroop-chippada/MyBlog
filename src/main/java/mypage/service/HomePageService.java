package mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypage.dao.HomePageDAO;
import mypage.domain.Question;

@Service
public class HomePageService {

	@Autowired
	private HomePageDAO homePageDAO;

	public List<Question> getQuestions() {
		return homePageDAO.getQuestions();
	}

	public void postQuestion(Question question) {
		homePageDAO.postQuestion(question);
	}

	public void setHomePageDAO(HomePageDAO homePageDAO) {
		this.homePageDAO = homePageDAO;
	}

}
