package quiztime;

public class Questions {
	
	protected String question;
	protected String quizAnswer;
	protected String correctAnswer;
	
	public Questions(String question, String answer) {
		this.question = question;
		this.correctAnswer = answer;
		this.quizAnswer = null;
	}
	
	public void setQuizAnswer(String quizAnswer) {
		this.quizAnswer = quizAnswer;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	public String getQuizAnswer() {
		return quizAnswer;
	}
	
	public boolean isCorrect() {
		return quizAnswer.equals(correctAnswer);
	}
	
	public String toString() {
		if (quizAnswer == null)
			return question;
		return question + "\nYour Answer: " + quizAnswer + "\nCorrect Answer: " + correctAnswer + "\nYour answer was correct: " + this.isCorrect();
	}
	
	public static void main(String[] args) {
		Questions q = new Questions("Name?", "Josh");
		System.out.println(q);
		q.setQuizAnswer("jack");
		System.out.println(q);
		q.setQuizAnswer("Josh");
		System.out.println(q);
	}
}
