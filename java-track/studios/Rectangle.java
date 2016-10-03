
public class Rectangle {
	
	/**
	 * @instance variables
	 */
	private double length, width;

	
	/**
	 * @constructor
	 */
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	
	/**
	 * @to string
	 */
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}
	
	
	/**
	 * @getters/setters
	 */
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	
	/**
	 * @other methods
	 */
	public double area() {
		return length * width;
	}
	
	public double perimeter() {
		return (2 * length) + (2 * width);
	}
	
	public boolean isSmaller(Rectangle r) {
		return this.area() < r.area();
	}
	
	public boolean isSquare() {
		return length == width;
	}
	
	/**
	 * @main
	 */
	public static void main(String[] args) {
		double l = 5;
		double w = 6;
		Rectangle r = new Rectangle(l, w);
		System.out.println(r.toString());
	}
}