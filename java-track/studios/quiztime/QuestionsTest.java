package quiztime;

import static org.junit.Assert.*;

import org.junit.Test;

import robotclass.Robot;

public class QuestionsTest {

	@Test
	public void testIsCorrect() {
		Questions q = new Questions("Name?", "Josh");
		q.setQuizAnswer("John");
		assertFalse("answer is incorrect", q.isCorrect());
		q.setQuizAnswer("Josh");
		assertTrue("answer is correct", q.isCorrect());
	}

}
