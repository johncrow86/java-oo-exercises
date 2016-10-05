
public class BaseballPlayer {
	
	private String name;
	private int jerseyNumber;
	private String swingStyle;
	private int hits;
	private int RBIs;
	private int gamesPlayed;
	
	public BaseballPlayer(String name, int jerseyNumber, String swingStyle) {
		this.name = name;
		this.jerseyNumber = jerseyNumber;
		this.swingStyle = swingStyle;
		this.hits = 0;
		this.RBIs = 0;
		this.gamesPlayed = 0;
	}
	
	public BaseballPlayer(String name, int jerseyNumber) {
		this(name, jerseyNumber, "none");
	}

	public String toString() {
		return "Name: " + name +
				"\nJersey Number: " + jerseyNumber +
				"\nSwing Style: " + swingStyle +
				"\nHits: " + hits +
				"\nRBIs: " + RBIs +
				"\nTotal Games Played: " + gamesPlayed;
	}
	
	public void setSwingStyle(String style) {
		this.swingStyle = style;
	}
	
	public void addHits(int h) {
		hits += h;
	}
	
	public void addRBIs(int r) {
		RBIs += r;
	}
	
	public void addGamePlayed() {
		gamesPlayed++;
	}
	
	public void addGamePlayed(int h, int r) {
		gamesPlayed++;
		hits += h;
		RBIs += r;
	}
	
	
	public static void main(String[] args) {
		BaseballPlayer p = new BaseballPlayer("John", 76, "left");
		p.addHits(3);
		p.addRBIs(5);
		p.addGamePlayed();
		System.out.println(p);
	}

}
