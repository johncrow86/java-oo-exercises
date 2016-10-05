package rectangle;

import static org.junit.Assert.*;

import org.junit.Test;

import robotclass.Robot;

public class RectangleTest {

	@Test
	public void testArea() {
		Rectangle r = new Rectangle(5, 6);
		assertTrue("area is incorrect(at)", r.area() == 30);
		assertEquals("area is incorrect(ae)", r.area(), 30, 0);
	}
	
	@Test
	public void testPerimeter() {
		Rectangle r = new Rectangle(5, 6);
		assertEquals("perimeter is incorrect", r.perimeter(), 22, 0);
	}
	
	@Test
	public void testIsSmaller() {
		Rectangle r1 = new Rectangle(5, 6);
		Rectangle r2 = new Rectangle(4, 5);
		assertFalse("rectangle 1 is larger", r1.isSmaller(r2));
		assertTrue("rectangle 2 is smaller", r2.isSmaller(r1));
	}
	
	@Test
	public void testIsSquare() {
		Rectangle r1 = new Rectangle(5, 6);
		Rectangle r2 = new Rectangle(4, 4);
		assertFalse("rectangle 1 is not square", r1.isSquare());
		assertTrue("rectangle 2 is square", r2.isSquare());
	}

}
