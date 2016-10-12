package robotclass;

public class DanceRobot extends Robot {

	protected String style;
	protected int movesBusted;
	protected boolean nationWideDanceInspired;
	
	public DanceRobot(String name, int[] position, int speed, char direction, String style) {
		super(name, position, speed, direction);
		this.style = style;
		movesBusted = 0;
		nationWideDanceInspired = false;
	}
	
	public DanceRobot(String name, int[] position, int speed, char direction) {
		this(name, position, speed, direction, "none");
	}
	
	public int getMovesBusted() {
		return movesBusted;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	public void bustAMove(int movesBusted) {
		this.movesBusted += movesBusted;
	}
	
	public void inspireANation() {
		if (this.style == "robot" && this.movesBusted >= 100)
			this.nationWideDanceInspired = true;
	}
	
	public String toString() {
		return "Name: " + name + " - Position: " + position[0] + "," +
				position[1] + " - Speed: " + speed + " - Direction: " +
				direction + " - Style: " + style + " - National Inspiration: " +
				nationWideDanceInspired;
	}
	
	//interface options
	public void doNextMove() {
		this.bustAMove(1);
		this.inspireANation();
	}
}
