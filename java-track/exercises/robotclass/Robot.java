package robotclass;

public class Robot {

	private String name;
	private int[] position = new int[2]; 
	private int speed;
	private char direction;
	
	public Robot(String name, int[] position, int speed, char direction) {
		this.name = name;
		this.position = position;
		this.speed = speed;
		this.direction = direction;
	}
	
//	public Robot() {
//		this("", {0,0}, 0, 'N');
//	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setDirection(char direction) {
		this.direction = direction;
	}
	
	public char getDirection() {
		return direction;
	}
	
	public int getXcoord() {
		return position[0];
	}
	
	public int getYcoord() {
		return position[1];
	}
	
	public void move() {
		if (direction == 'N')
			position[1] = position[1] + speed;
		else if (direction == 'S')
			position[1] = position[1] - speed;
		else if (direction == 'E')
			position[0] = position[0] + speed;
		else if (direction == 'W')
			position[0] = position[0] - speed;
		else
			return;
	}
	
	public void rotate(String newDirection) {
		if (newDirection == "left") {
			if (direction == 'N') direction = 'W';
			else if (direction == 'S') direction = 'E';
			else if (direction == 'E') direction = 'N';
			else if (direction == 'W') direction = 'S';
		} else if (newDirection == "right") {
			if (direction == 'N') direction = 'E';
			else if (direction == 'S') direction = 'W';
			else if (direction == 'E') direction = 'S';
			else if (direction == 'W') direction = 'N';
		} else {
			return;
		}
	}
	
	public double distance(Robot r1) {
		double deltaY = r1.getYcoord() - this.getYcoord();
		double deltaX = r1.getXcoord() - this.getXcoord();
		return Math.abs( Math.sqrt( Math.pow(deltaY, 2) + Math.pow(deltaX, 2)) );
	}
	
	public String toString() {
		return "Name: " + name + " - Position: " + position[0] + "," + position[1] + " - Speed: " + speed + " - Direction: " + direction;
	}
	
}