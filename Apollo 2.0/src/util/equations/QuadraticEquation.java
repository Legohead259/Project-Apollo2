package util.equations;

public class QuadraticEquation {
	
	
	//*****START VARAIBLES*****
	
	
	/**
	 * The a, b, and c values of the quadratic formula respectfully
	 */
	double a, b, c;
	
	/**
	 * The discriminant of the quadratic formula
	 */
	double discriminant;
	
	/**
	 * The biggest solution to the quadratic formula. Will return -1 if not valid
	 */
	public double solution;
	
	
	//*****END VARIABLES*****
	
	
	//*****START CONSTRUCTOR*****
	
	
	/**
	 * Quadratic equation constructor
	 * @param a the a value of the quadratic formula
	 * @param b the b value of the quadratic formula
	 * @param c the c value of the quadratic formula
	 */
	public QuadraticEquation(double a, double b, double c) {
		this.a = a; this.b = b; this.c = c;
	}
	
	
	//*****END CONSTRUCTOR*****
	
	
	//*****START SOLVING METHODS*****

	
	/**
	 * Method that solves the quadratic equation
	 */
	public void solveEquation() {
		calcDiscriminant();
		
		double bPlus = b + Math.sqrt(discriminant) / 2 * a;
		double bMinus = b - Math.sqrt(discriminant) / 2 * a;
		
		if (bPlus > bMinus && bPlus > 0) {
			solution = bPlus;
		}
		
		else if (bMinus > bPlus && bMinus > 0) {
			solution = bMinus;
		}
		
		else {
			solution = -1;
		}
	}
	
	/**
	 * Method that solves the discriminant of the quadratic formula
	 */
	void calcDiscriminant() {
		double bsqrd = Math.pow(b, 2);
		
		discriminant = bsqrd - 4 * a * c;
	}
	
	
	//*****END SOLVING METHODS*****
}
