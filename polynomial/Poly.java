package polynomial;

import java.util.Arrays;

public final class Poly {
	private final int coefficient[];

	/**
	 * @return the coefficient
	 */
	public int[] getCoefficient() {
		return coefficient;
	}

	Poly(int coefficient[]) {
		this.coefficient = coefficient;
		if (!checkPoly()) {
			throw new AssertionError("cofficient can not be zero");
		}
	}

	/**
	 * for getting the size of polynomial
	 * 
	 * @return
	 */
	public int getDegree() {
		return coefficient.length - 1;
	}

	/**
	 * evaluating the polynomial function at x
	 * 
	 * @param x
	 * @return the value of polynomial
	 */
	public float Evaluate(float x) {
		int degree = getDegree();
		float eval = (float) 0.0; // evaluated value is zero initially
		for (int i = degree; i >= 0; i--) {
			eval = eval + coefficient[degree - i] * (float) Math.pow(x, i);

		}
		return eval;
	}

	/**
	 * function adds two polynomial functions
	 * 
	 * @param poly2
	 * @return the polynomial which is addition
	 */
	public Poly addPoly(Poly poly2) {

		int poly1Coff[] = coefficient;
		int poly2Coff[] = poly2.getCoefficient();

		int largePoly[] = poly1Coff.length > poly2Coff.length ? poly1Coff
				: poly2Coff;
		int smallPoly[] = poly1Coff.length < poly2Coff.length ? poly1Coff
				: poly2Coff;

		int addPoly[] = new int[largePoly.length];
		int distinct = largePoly.length - smallPoly.length;

		int index;
		for (index = 0; index < distinct; index++) {
			addPoly[index] = largePoly[index];

		}

		while (index < largePoly.length) {
			addPoly[index] = smallPoly[index - distinct] + largePoly[index];
			index++;
		}

		return (new Poly(addPoly));
	}

	/**
	 * multiplying two array
	 * 
	 * @param poly2
	 * @return
	 */

	Poly multiply(Poly poly2) {
		int multipliedPoly[] = new int[this.getDegree() + poly2.getDegree() + 1];

		int poly1Coff[] = coefficient;
		int poly2Coff[] = poly2.getCoefficient();

		int largePoly[] = poly1Coff.length > poly2Coff.length ? poly1Coff
				: poly2Coff;
		int smallPoly[] = poly1Coff.length < poly2Coff.length ? poly1Coff
				: poly2Coff;

		for (int smallPolyIndex = smallPoly.length - 1; smallPolyIndex >= 0; smallPolyIndex--) {
			for (int largePolyIndex = largePoly.length - 1; largePolyIndex >= 0; largePolyIndex--) {
				multipliedPoly[smallPolyIndex + largePolyIndex] = multipliedPoly[smallPolyIndex
						+ largePolyIndex]
						+ smallPoly[smallPoly.length - smallPolyIndex - 1]
						* largePoly[largePoly.length - largePolyIndex - 1];
			}
		}
		// reversing the array
		int tempArray[] = new int[multipliedPoly.length];
		for (int i = 1; i <= multipliedPoly.length; i++) {
			tempArray[i - 1] = multipliedPoly[multipliedPoly.length - i];
		}
		multipliedPoly = tempArray;

		return new Poly(multipliedPoly);
	}

	/**
	 * if any coefficient is zero returns false
	 * 
	 * @return
	 */
	private boolean checkPoly() {
		boolean flag = true;
		for (int i = 0; i < coefficient.length; i++) {
			if (coefficient[i] == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String a[]) {
		int array1[] = new int[] { 2, 5, 6 };
		Poly p1 = new Poly(array1);
		int array2[] = new int[] { 2, 5, 5, 3 };
		Poly p2 = new Poly(array2);

		Poly p3 = p2.multiply(p1);
		System.out.println(Arrays.toString(p3.getCoefficient()));

		System.out.println(p1.Evaluate((float) 4.5));
	}

}
