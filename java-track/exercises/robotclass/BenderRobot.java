package robotclass;

public class BenderRobot extends Robot {
	
	protected boolean clamps; // true is closed
	
	public BenderRobot (String name, int[] position, int speed, char direction) {
		super(name, position, speed, direction);
		clamps = false;
	}
	
	public void useClamps() {
		if (this.clamps == true)
			this.clamps = false;
		else
			this.clamps = true;
	}
	
	public boolean bend() {
		if (clamps == true)
			return true;
		else
			return false;
	}
	
	public String toString() {
		return "Name: " + name + " - Position: " + position[0] + "," +
				position[1] + " - Speed: " + speed + " - Direction: " +
				direction + " - Clamps: " + convertBool(clamps);
	}
	
	public String convertBool(boolean b) {
		String s = "";
		if (b == true)
			s = "Closed";
		else
			s = "Open";
		return s;
	}
	
	public static void main(String args[]) {
		int[] pos = {0,0};
		BenderRobot br = new BenderRobot("r1", pos, 1, 'N');
		System.out.println(br);
	}
}
