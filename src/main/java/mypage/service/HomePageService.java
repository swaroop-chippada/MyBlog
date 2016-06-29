package main.java.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.mypage.dao.GenericDAO;
import main.java.mypage.domain.Question;

@Service
public class HomePageService {

	@Autowired
	private GenericDAO genericDAO;

	public List<Question> getQuestions() {
		return genericDAO.getQuestions();
	}

	public void postQuestion(Question question) {
		genericDAO.postQuestion(question);
	}

	public void setGenericDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}
	
}
