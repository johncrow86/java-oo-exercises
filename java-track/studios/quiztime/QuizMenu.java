package quiztime;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizMenu {

	protected ArrayList<Questions> questions;
	protected Scanner s;
	
	public static void main(String[] args) {
		QuizMenu qm = new QuizMenu();
		qm.fillList();
		int index = qm.loadQuestion();
		qm.getAnswer(index);
		System.out.println(qm.toString(index));
	}
	
	public QuizMenu() {
		questions = new ArrayList<Questions>();
		s = new Scanner(System.in);
	}
	
	public String toString(int index) {
		return questions.get(index).toString();
	}
	
	public int loadQuestion() {
		int numOfQuestions = questions.size();
		int indexNumber = (int)(Math.random() * numOfQuestions);
		String q = questions.get(indexNumber).getQuestion();
		System.out.println(q);
		return indexNumber;
	}
	
	public void getAnswer(int indexNumber) {
		String a = s.next();
		questions.get(indexNumber).setQuizAnswer(a);
	}
	
	public void fillList() {
		Questions q1 = new Questions("What color is the sky?", "blue");
		Questions q2 = new Questions("What color is the grass?", "green");
		Questions q3 = new Questions("What color is a zebra?", "blackwhite");
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
	}
}
