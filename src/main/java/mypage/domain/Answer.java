package mypage.domain;

public class Answer {

	private long id;
	private String answer;
	private long questionId;
	private String responderName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getResponderName() {
		return responderName;
	}
	public void setResponderName(String responderName) {
		this.responderName = responderName;
	}
	
}
