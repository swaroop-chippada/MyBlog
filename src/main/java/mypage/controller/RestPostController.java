package mypage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypage.domain.Question;
import mypage.service.QuestionService;

@RestController
public class RestPostController {

	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "/ajax/postQuestion", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public void postQuestion(@RequestBody Question question) {
		question.setDateCreated(new Date());
		questionService.postQuestion(question);
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

}
