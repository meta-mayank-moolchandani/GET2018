package polynomial2;

public final class Poly {
	private final int poly[][]; //first row is power
	                            //second row is coefficient 

	/**
	 * @return the polynomial array
	 */
	public int[][] getPoly() {
		int array[][] = new int[2][poly[0].length];
		for (int row = 0; row < 2; row++) {
			for (int column = 0; column < poly[0].length; column++) {
				array[row][column] = poly[row][column];
			}
		}
		return poly;
	}

/**
 * polynomial will be invalid if any coefficient is zero and and power is duplicate	
 * @param poly
 */
	Poly(int poly[][]) {
		this.poly = sortPoly(poly);
		if (!checkPoly()) {
			throw new AssertionError("please enter a valid polynomial");
		}
	}

/**
 * sorting the powers in decreasing order 
 * @param array
 * @return
 */
	public int[][] sortPoly(int array[][]){
		for(int i= 0; i<array[0].length; i++){
			for(int j =0; j<array[0].length-i-1;j++){
				if(array[0][j]<array[0][j+1]){
					int temp = array[0][j];
					array[0][j]=array[0][j+1];
					array[0][j+1] = temp;
	     
					temp = array[1][j];
					array[1][j]=array[1][j+1];
				    array[1][j+1] = temp;	
				}
			}
		}
		return array;
	}

	/**
	 * for getting the size of polynomial
	 * 
	 * @return
	 */
	public int getDegree() {
	    return poly[0][0];
	}

	/**
	 * evaluating the polynomial function at x
	 * 
	 * @param x
	 * @return the value of polynomial
	 */
	public float Evaluate(float x) {
		float eval = (float) 0.0; // evaluated value is zero initially
		for(int i= 0; i<poly[0].length;i++){
			eval = eval + poly[1][i] * (float)Math.pow(x,poly[0][i]);
		}
        return eval;
	}

	/**
	 * function adds two polynomial functions
	 * 
	 * @param poly2
	 * @return the new Poly which is addition of this.Poly and passed poly2
	 */
	public Poly addPoly(Poly poly2) {
		int polyArray1[][] = this.getPoly();
		int polyArray2[][] = poly2.getPoly();

		int array1Index = 0;
		int array2Index = 0;
		int unionIndex = 0;
		int union[][] = new int[2][polyArray1[0].length + polyArray2[0].length];
		while (array1Index < polyArray1[0].length
				&& array2Index < polyArray2[0].length) {
			
			if (polyArray1[0][array1Index] < polyArray2[0][array2Index]) {
				union[0][unionIndex] = polyArray2[0][array2Index];
				union[1][unionIndex] = polyArray2[1][array2Index];
				array2Index++;
			} else if (polyArray1[0][array1Index] > polyArray2[0][array2Index]) {
				union[0][unionIndex] = polyArray1[0][array1Index];
				union[1][unionIndex] = polyArray1[1][array1Index];
				array1Index++;
			} else {
				union[0][unionIndex] = polyArray1[0][array1Index];
				union[1][unionIndex] = polyArray1[1][array1Index] //performing addition for same power
						+ polyArray2[1][array2Index];
				array1Index++;
				array2Index++;
			}
			unionIndex++;
		}

		while (array1Index < polyArray1[0].length) {
			union[0][unionIndex] = polyArray1[0][array1Index];
			union[1][unionIndex] = polyArray1[1][array1Index];
			array1Index++;
			unionIndex++;
		}
		while (array2Index < polyArray2[0].length) {
			union[0][unionIndex] = polyArray2[0][array2Index];
			union[1][unionIndex] = polyArray2[1][array2Index];
			array2Index++;
			unionIndex++;
		}

		int finalUnion[][] = new int[2][unionIndex]; // for deleting extra
														// elements
		for (int row = 0; row < 2; row++) {
			for (int column = 0; column < finalUnion[row].length; column++) {
				finalUnion[row][column] = union[row][column];
			}
		}
		return (new Poly(finalUnion));
	}

	/**
	 * multiplying two array
	 * 
	 * @param poly2
	 * @return
	 */

	Poly multiply(Poly poly2) {
		int Poly1Array[][] = this.getPoly();
		int Poly2Array[][] = poly2.getPoly();
     	
		Poly polyArray[] = new Poly[Poly1Array[0].length]; //array of polynomial for string each iterations 
     	
     	for(int index = 0; index<polyArray.length;index++){ //index is the index of polynomial array
			
     		int tempArray[][] = new int[Poly2Array.length][Poly2Array[0].length];
			
			for (int j = 0; j < Poly2Array[0].length; j++) { // j is index of
																// poly2Array
				tempArray[0][j] = Poly1Array[0][index] + Poly2Array[0][j];
				tempArray[1][j] = Poly1Array[1][index] * Poly2Array[1][j];
			}
			// System.out.println(Arrays.toString(arr[0]));
			// System.out.println(Arrays.toString(arr[1])+"\n");
			polyArray[index] = new Poly(tempArray);
		}

		Poly sum = polyArray[0];
		for (int j = 1; j < polyArray.length; j++) {
			sum = sum.addPoly(polyArray[j]);
		}
		return sum;
	}

	/**
	 * if any coefficient is zero returns false
	 * 
	 * @return
	 */
	private boolean checkPoly() {
		boolean flag = true;
		for (int index = 0; index < poly[0].length; index++) {
			if (poly[1][index] == 0) {
				flag = false;//if any coefficient is zero
				break;
			}
		}
		
		for(int index=0; index<poly[0].length-1;index++){  
			if(poly[0][index]==poly[0][index+1]){
				flag = false;//if any power is duplicate
				break;
			}
		}
		return flag;
	}
}
