package robotclass;
import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testMoveN() {
		int[] position = {0, 0};
		Robot r1 = new Robot("robot1", position, 2, 'N');
		r1.move();
		assertTrue("Xcoord is incorrect", r1.getXcoord() == 0);
		assertTrue("Ycoord is incorrect", r1.getYcoord() == 2);
	}

	@Test
	public void testMoveS() {
		int[] position = {0, 0};
		Robot r1 = new Robot("robot1", position, 2, 'S');
		r1.move();
		assertTrue("Xcoord is incorrect", r1.getXcoord() == 0);
		assertTrue("Ycoord is incorrect", r1.getYcoord() == -2);
	}
	
	@Test
	public void testMoveW() {
		int[] position = {0, 0};
		Robot r1 = new Robot("robot1", position, 2, 'E');
		r1.move();
		assertTrue("Xcoord is incorrect", r1.getXcoord() == 2);
		assertTrue("Ycoord is incorrect", r1.getYcoord() == 0);
	}
	
	@Test
	public void testMoveE() {
		int[] position = {0, 0};
		Robot r1 = new Robot("robot1", position, 2, 'W');
		r1.move();
		assertTrue("Xcoord is incorrect", r1.getXcoord() == -2);
		assertTrue("Ycoord is incorrect", r1.getYcoord() == 0);
	}
	
	@Test
	public void testRotateLeft() {
		int[] position = {0, 0};
		Robot r1 = new Robot("robot1", position, 2, 'N');
		r1.rotate("left");
		assertTrue("Direction is incorrect", r1.getDirection() == 'W');
		r1.rotate("left");
		assertTrue("Direction is incorrect", r1.getDirection() == 'S');
		r1.rotate("left");
		assertTrue("Direction is incorrect", r1.getDirection() == 'E');
	}
	
	@Test
	public void testRotateRight() {
		int[] position = {0, 0};
		Robot r1 = new Robot("robot1", position, 2, 'N');
		r1.rotate("right");
		assertTrue("Direction is incorrect", r1.getDirection() == 'E');
		r1.rotate("right");
		assertTrue("Direction is incorrect", r1.getDirection() == 'S');
		r1.rotate("right");
		assertTrue("Direction is incorrect", r1.getDirection() == 'W');
	}
	
	@Test
	public void testDistance() {
		int[] position1 = {0, 0};
		int[] position2 = {5, 5};
		Robot r1 = new Robot("robot1", position1, 2, 'N');
		Robot r2 = new Robot("robot2", position2, 2, 'N');
		assertEquals("Distance is incorrect", r1.distance(r2), 7.071, .001);
		int[] position3 = {12, 17};
		Robot r3 = new Robot("robot1", position3, 2, 'N');
		assertEquals("Distance is incorrect", r2.distance(r3), 13.892, .001);
	}
	
	@Test
	public void testBenderRobot() {
		int[] pos = {0,0};
		BenderRobot br = new BenderRobot("r1", pos, 1, 'N');
		assertTrue("clamps are false(open), should not bend", br.bend() == false);
		br.useClamps();
		assertTrue("problem switching clamps to true(closed)", br.clamps == true);
		br.bend();
		assertTrue("problem switching bend to true", br.bend() == true);
		br.useClamps();
		assertTrue("problem switching clamps to false(open)", br.clamps == false);
	}
	
	@Test
	public void testDanceRobot() {
		int[] pos = {0,0};
		DanceRobot dr = new DanceRobot("r1", pos, 1, 'N');
		dr.bustAMove(10);
		assertTrue("problem busting 10 moves", dr.movesBusted == 10);
		dr.inspireANation();
		assertTrue("dance should not inspire do to prerequs", dr.nationWideDanceInspired == false);
		dr.bustAMove(90);
		assertTrue("dance should not inspire do style", dr.nationWideDanceInspired == false);
		dr.setStyle("robot");
		dr.inspireANation();
		assertTrue("problem inspiring dance", dr.nationWideDanceInspired == true);
	}
}
