package robotclass;

import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	
	private ArrayList<Robot> robots;
	private Scanner s;
	
	public static void main(String[] args) {
		
		int x = 0;
		
		RobotMenu rm = new RobotMenu();
		do {
			x = rm.loadMenu();
			rm.processInput(x);
		} while (x != 6);
	}
	
	public RobotMenu() {
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public int loadMenu() {
		int selection;
		
		do {
			System.out.println(" Robot Menu");
			System.out.println("1. Create a Robot");
			System.out.println("2. Display the list of available Robots");
			System.out.println("3. Move a Robot");
			System.out.println("4. Rotate a Robot");
			System.out.println("5. Compute the distance between 2 Robots");
			System.out.println("6. Exit");

			if (s.hasNextInt()) {
				selection = s.nextInt();
				if (selection < 1 || selection > 6)
					System.out.println("Please enter a number between 1 and 6");
			} else {
				System.out.println("That is not a number");
				String trash = s.next();
				selection = 0;
			}
		} while (selection < 1 || selection > 6);
		
		return selection;
	}
	
	public void processInput(int selection) {
		if (selection == 1) {
			createRobot();
			displayRobots();
		}
		else if (selection == 2)
			displayRobots();
		else if (selection == 3) {
			displayRobots();
			Robot r = selectRobot();
			r.move();
		} else if (selection == 4) {
			displayRobots();
			Robot r = selectRobot();
			System.out.println("Enter a direction to rotate (left or right)");
			String direction = s.next();
			if (direction == "left")
				r.rotate("left");
			else if (direction == "right")
				r.rotate("right");
			else
				System.out.println("Uknown direction");
		} else if (selection == 5) {
			displayRobots();
			Robot r1 = selectRobot();
			Robot r2 = selectRobot();
			System.out.println("The distance between the robots is " + r1.distance(r2));
		}
	}
	
	private void displayRobots() {
		for (int i = 0; i < robots.size(); i++) {
			System.out.println((i+1) + ".) " + robots.get(i));
		}
		System.out.println();
	}
	
	private Robot selectRobot() {
		System.out.println("Select a Robot");
		int selection = s.nextInt();
		while (selection < 1 || selection > robots.size()) {
			System.out.println("Invalid selection");
			selection = s.nextInt();
		}
		return robots.get(selection-1);
	}
	
	private void createRobot() {
		System.out.println("Enter a name for the Robot");
		String name = s.next();
		System.out.println("Enter an X and Y coordinates seperated by a space");
		int xCoord = s.nextInt();
		int yCoord = s.nextInt();
		int[] pos = {xCoord, yCoord};
		System.out.println("Enter a speed for the Robot");
		int speed = s.nextInt();
		System.out.println("Robot will face North. Cannot s.nextChar()");
		char direction = 'N';
		robots.add(new Robot(name, pos, speed, direction));
	}
}
