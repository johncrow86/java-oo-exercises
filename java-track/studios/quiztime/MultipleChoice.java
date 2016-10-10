package quiztime;

public class MultipleChoice extends Questions {
	
	protected int numChoices;
	protected String[] choices;
	
	public MultipleChoice(String question, String correctAnswer, int numChoices, String[] choices) {
		super(question, correctAnswer);
			this.numChoices = numChoices;
			choices = new String[numChoices];
			this.choices = choices;
	}
	
	public void setChoice(int position, String choice) {
		if (position < choices.length)
			choices[position] = choice;
	}
	
	public String toString() {
		String response = question;
		for (int i = 0; i < choices.length; i++) {
			response += "\n" + i+1 + ") " + choices[i];
		}
		
		if (quizAnswer == null)
			return response;
		response += "\nYour Answer: " + quizAnswer + "\nCorrect Answer: " + correctAnswer + "\nYour answer was correct: " + this.isCorrect();
		return response;
	}

}
