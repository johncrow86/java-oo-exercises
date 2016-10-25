package gradebook;

import java.text.DecimalFormat;
import java.util.Objects;

import blogz.Entity;

public class Student {
	
	private String nameFirst;
	private String nameLast;
	private int studentID;
	private int credits;
	private double GPA;
	
	private static int numStudents;
	
	public Student(String first, String last, int ID, int credits, double GPA) {
		this.nameFirst = first;
		this.nameLast = last;
		this.studentID = ID;
		this.credits = credits;
		this.GPA = GPA;
		numStudents++;
	}
	
	public Student(String first, String last, int ID) {
		this(first, last, ID, 0, 0);
	}
	
	public String toString() {
		return "Name: " + nameFirst + " " + nameLast + " - Student ID: " + studentID;
	}
	
	@Override
	public boolean equals(Object o) {
		
	    // self check
	    if (this == o)
	        return true;
	    
	    // null check
	    if (o == null)
	        return false;
	    
	    // type check and cast
	    if (!(o instanceof Student))
	        return false;
	    
	    Student s = (Student) o;
	    
	    // field comparison
	    return Objects.equals(studentID, s.studentID);
	}

	public String getName() {
		return nameFirst + " " + nameLast;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public double getGPA() {
		return GPA;
	}
	
	public String getClassStanding() {
		if (credits < 30)
			return "Freshman";
		if (credits < 60)
			return "Sophomore";
		if (credits < 90)
			return "Junior";
		return "Senior";
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public void submitGrade(double grade, int credits) {
		DecimalFormat df = new DecimalFormat("#.000");
		
		double totalPoints = this.credits * 4.0;
		double qualityPoints = this.credits * this.GPA;
		
		totalPoints += (credits * 4);
		qualityPoints += (credits * grade);
		this.credits += credits;
		this.GPA = new Double(df.format(qualityPoints/totalPoints * 4.0)).doubleValue();
	}
	
	public double computeTuition() {
		DecimalFormat df = new DecimalFormat("#.00");
		
		double tuition = credits / 15 * 20000;
		int creditsRemaining = credits % 15;
		
		double costPerCredit = new Double(df.format(20000.0 / 15.0)).doubleValue();
		double tuitionRemaining = new Double(df.format(costPerCredit * creditsRemaining)).doubleValue();
		
		return tuition + tuitionRemaining;
	}
	
	public Student createLegacy(Student self, Student s) {
		String firstName = this.getName();
		String lastName = s.getName();
		int ID = this.studentID + s.studentID;
		double GPA = (this.GPA + s.GPA) / 2.0;
		int Credits = (this.credits > s.credits) ? this.credits : s.credits;
		return new Student(firstName, lastName, ID, Credits, GPA);
	}
	
	public Student createLegacy(Student s) {
		String firstName = this.getName();
		String lastName = s.getName();
		int ID = this.studentID + s.studentID;
		double GPA = (this.GPA + s.GPA) / 2.0;
		int Credits = (this.credits > s.credits) ? this.credits : s.credits;
		return new Student(firstName, lastName, ID, Credits, GPA);
	}
	
	public static void main(String[] args) {
		Student s = new Student("F", "L", 1, 100, 3.0);
		s.submitGrade(3, 4);
	}
}
