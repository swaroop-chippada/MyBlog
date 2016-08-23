package mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypage.dao.GenericDAO;
import mypage.domain.Question;

@Service
public class QuestionService {

	@Autowired
	private GenericDAO genericDAO;

	public List<Question> getQuestions() {
		return genericDAO.getQuestions(Question.class);
	}

	public void postQuestion(Question question) {
		genericDAO.postQuestion(question);
	}

	public void setHomePageDAO(GenericDAO genericDAO) {
		this.genericDAO = genericDAO;
	}

}
