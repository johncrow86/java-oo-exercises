package robotclass;

public class Robot implements RobotInterface {

	protected String name;
	protected int[] position = new int[2]; 
	protected int speed;
	protected char direction;
	
	public Robot(String name, int[] position, int speed, char direction) {
		this.name = name;
		this.position = position;
		this.speed = speed;
		if (direction != 'N' && direction != 'S' && direction != 'W' && direction != 'E')
			throw new IllegalArgumentException("Invalid direction");
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
		} else
			throw new IllegalArgumentException("Can only rotate left or right");
	}
	
	public double distance(Robot r1) {
		double deltaY = r1.getYcoord() - this.getYcoord();
		double deltaX = r1.getXcoord() - this.getXcoord();
		return Math.abs( Math.sqrt( Math.pow(deltaY, 2) + Math.pow(deltaX, 2)) );
	}
	
	//interface options
	public void doNextMove() {
		//overwritten in specific robots
	}
	
	public String toString() {
		return "Name: " + name + " - Position: " + position[0] + "," + position[1] + " - Speed: " + speed + " - Direction: " + direction;
	}
	
	public static void main (String[] args) {
		int[] pos = {2,0};
		Robot r = new Robot("this", pos, 5, 'N');
		System.out.println(r);
		r.rotate("left");
		System.out.println(r);
	}
	
}