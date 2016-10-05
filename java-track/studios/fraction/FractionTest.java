package fraction;

import static org.junit.Assert.*;

import org.junit.Test;

import rectangle.Rectangle;

public class FractionTest {

	@Test
	public void testAdd() {
		Fraction f1 = new Fraction(3,4);
		Fraction f2 = new Fraction(2,3);
		Fraction f3 = f1.add(f2);
		assertEquals("fraction numerator is incorrect", f3.getNumerator(), 17);
		assertEquals("fraction denominator is incorrect", f3.getDenominator(), 12);
	}
	
	@Test
	public void testMult() {
		Fraction f1 = new Fraction(3,4);
		Fraction f2 = new Fraction(2,3);
		Fraction f3 = f1.mult(f2);
		assertEquals("fraction numerator is incorrect", f3.getNumerator(), 6);
		assertEquals("fraction denominator is incorrect", f3.getDenominator(), 12);
	}
	
	@Test
	public void testRecip() {
		Fraction f1 = new Fraction(3,4);
		f1 = f1.recip();
		assertEquals("fraction numerator is incorrect", f1.getNumerator(), 4);
		assertEquals("fraction denominator is incorrect", f1.getDenominator(), 3);
	}
	
	@Test
	public void testSimplify() {
		Fraction f1 = new Fraction(3,9);
		f1 = f1.simplify();
		assertEquals("fraction numerator is incorrect", f1.getNumerator(), 1);
		assertEquals("fraction denominator is incorrect", f1.getDenominator(), 3);
	}

}
