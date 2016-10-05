package fraction;

public class Fraction {

	private int numerator, denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public String toString() {
		return "Fraction is " + numerator + "/" + denominator;
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}

	public Fraction add(Fraction f) {
		int commonDenom = denominator * f.denominator;
		return new Fraction((numerator * f.denominator) + (f.numerator * denominator), commonDenom);
	}

	public Fraction mult(Fraction f) {
		return new Fraction(numerator * f.numerator, denominator * f.denominator);
	}

	public Fraction recip() {
		return new Fraction(denominator, numerator);
	}

	public Fraction simplify() {
		int gcd = GCD(numerator, denominator);
		return new Fraction(numerator / gcd, denominator / gcd);
	}

	private int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}
	
	
	public static void main(String[] args) {
		Fraction f = new Fraction(12, 36);
		Fraction f2 = f.simplify();
		Fraction f3 = f.add(f2);
		System.out.println(f3);
		System.out.println(f3.simplify());
	}

}