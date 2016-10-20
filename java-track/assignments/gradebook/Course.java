package gradebook;

public class Course {
	
	private String name;
	private int credits;
	private int seatsRemain;
	private Student[] roster;
	
	private static int numCourses;
	private static int numCredits;
	
	public Course (String name, int credits, int seatsRemain) {
		this.name = name;
		this.credits = credits;
		this.seatsRemain = seatsRemain;
		this.roster = new Student[seatsRemain];
		numCourses++;
		numCredits += credits;
	}
	
	public String toString() {
		return "Name: " + name + " - Credits: " + credits;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public int getRemainingSeats() {
		return seatsRemain;
	}
	
	public static int getNumCourses() {
		return numCourses;
	}
	
	public static int getNumCredits() {
		return numCredits;
	}
	
	public static double avgCreditPerCourse() {
		return (double)numCredits/(double)numCourses;
	}

	public boolean addStudent(Student s) {
		// check if in class
		for (int i = 0; i < roster.length; i++){
			if (roster[i] != null) {
				if (roster[i].getName().equals(s.getName()))
					return false;
			}
		}
		// add to class
		for (int i = 0; i < roster.length; i++){
			if (roster[i] == null) {
				roster[i] = s;
				seatsRemain--;
				return true;
			}
		}
		// class is full
		return false;
	}
	
	public String generateRoster() {
		String list = "";
		if (roster != null) {
			for (int i = 0; i < roster.length; i++) {
				if (roster[i] != null) {
					list += "1) " + roster[i].getName() + "\n";
				}
			}
		}
		return list;
	}
	
	public double averageGPA() {
		double GPA = 0.0;
		int students = 0;
		if (roster != null) {
			for (int i = 0; i < roster.length; i++) {
				if (roster[i] != null) {
					GPA += roster[i].getGPA();
					students++;
				}
			}
		}
		return GPA/students;
	}
}
