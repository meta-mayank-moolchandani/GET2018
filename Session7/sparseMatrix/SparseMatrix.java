package sparseMatrix;

import java.util.ArrayList;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

final public class SparseMatrix {
	final int sparse[][];
	final int rows;
	final int columns;
	
	/**
	 * performing deep copy for maintaining immutability 
	 * @return new array which is copy of sparse matrix
	 */
	int[][] getSparse(){
		int array[][] = new int[sparse.length][3];
		for(int i = 0; i<sparse.length; i++){ //i is row's index
			for(int j =0; j<sparse[0].length; j++){//j is column's index
				array[i][j] = sparse[i][j];
			}
		}
		return array;
		
	}
	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}


	/**
	 * @return the columns
	 */
	public int getColumns() {
		return columns;
	}


	SparseMatrix(int sparse[][],int rows, int columns){
		int arr[][] = new int[sparse.length][3];
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr[0].length;j++){
				arr[i][j] = sparse[i][j];
			}
		}
		this.sparse = sort(arr);
		this.rows = rows;
		this.columns = columns;
		
		if(!checkSparse()){
			throw new RuntimeErrorException(null, "Sparse matrix is invalid");
		}
	}
	
	

/**
 * sorting the rows and columns of matrix a
 * @param a
 * @return
 */
	private int[][] sort(int a[][]) {
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length - 1; i++) {
				if (a[i][0] > a[i + 1][0]) {
					for (int k = 0; k < 3; k++) {
						// swapping for row i and column k
						int temp = a[i][k];
						a[i][k] = a[i + 1][k];
						a[i + 1][k] = temp;
					}
				}
				if (a[i][0] == a[i + 1][0] && a[i][1] > a[i + 1][1]) {
					for (int k = 1; k < 3; k++) {
						// swapping for row i and column k
						int temp = a[i][k];
						a[i][k] = a[i + 1][k];
						a[i + 1][k] = temp;
					}
				}
			}
		}
		return a;
	}

	/**
	 * matrix will be invalid if any index of column 0 is >= rows of matrix
	 * matrix will be invalid if any index of column 1 is >= columns of matrix
	 * two rows are equal
	 * 
	 * @return true if valid
	 */

	private boolean checkSparse() {
		boolean flag = true;
		for (int i = 0; i < sparse.length; i++) {
			if (sparse[i][0] >= rows) {
				flag = false;
				break;
			}
			if (sparse[i][1] >= columns) {
				flag = false; 
				break;
			}
		}

		for (int i = 0; i < sparse.length-1; i++) {
			if ((sparse[i][0] == sparse[i + 1][0])
					&& (sparse[i][1] == sparse[i + 1][1])) {
				flag = false; //if two addresses stores different values
				break;
			}
		}
		return flag;
	}
	
/**
 * adding two sparse matrix
 * @param sparseMatrix2
 * @return
 */
	public SparseMatrix Add(SparseMatrix sparseMatrix2) {
		int totalRows1 = this.getRows();
		int totalColumns1 = this.getColumns();
		int matrix1[][] = this.getSparse();

		int totalRows2 = sparseMatrix2.getRows();
		int totalColumns2 = sparseMatrix2.getColumns();
		int matrix2[][] = sparseMatrix2.getSparse();

		if (totalRows1 == totalRows2 && totalColumns1 == totalColumns2) {
			int matrix3[][] = mergeArray(matrix1, matrix2);
			int similarCount = 0;
			for (int index = 0; index < matrix3.length - 1; index++) {
				if (matrix3[index][0] == matrix3[index + 1][0]
						&& matrix3[index][1] == matrix3[index + 1][1]) {
					similarCount++;
				}
			}
			int addition[][] = new int[matrix3.length - similarCount][3];
			int additionIndex = 0;
			for (int matrix3Index = 0; matrix3Index < matrix3.length - 1; matrix3Index++, additionIndex++) {
				if (matrix3[matrix3Index][0] == matrix3[matrix3Index + 1][0]
						&& matrix3[matrix3Index][1] == matrix3[matrix3Index + 1][1]) {
					addition[additionIndex][0] = matrix3[matrix3Index][0];
					addition[additionIndex][1] = matrix3[matrix3Index][1];
					addition[additionIndex][2] = matrix3[matrix3Index][2] + matrix3[matrix3Index + 1][2];
					matrix3Index++;
				} else {
					addition[additionIndex][0] = matrix3[matrix3Index][0];
					addition[additionIndex][1] = matrix3[matrix3Index][1];
					addition[additionIndex][2] = matrix3[matrix3Index][2];
				}
			}
			return new SparseMatrix(addition, totalRows2, totalColumns2);
		} else {
			throw new RuntimeErrorException(null,
					"ADDITION CAN NOT BE PERFORMED. ORDERS OF MATRIX IS NOT EQUAL");
		}
	}
	
/**
 * multiply two sparse matrix
 * @param sparseMatrix2
 * @return
 */  
	public SparseMatrix multiplySparse(SparseMatrix sparseMatrix2) {
		int totalRows1 = this.getRows();
		int totalColumns1 = this.getColumns();
		int matrix1[][] = this.getSparse();

		int totalRows2 = sparseMatrix2.getRows();
		int totalColumns2 = sparseMatrix2.getColumns();

		SparseMatrix transpose2 = sparseMatrix2.transpose(); // transpose of
																// matrix 2
		int transposMatrix2[][] = transpose2.getSparse();

		ArrayList<int[]> resultList = new ArrayList<int[]>(); 

		if (totalColumns1 == totalRows2) {
			for (int matrix1Index = 0; matrix1Index < matrix1.length; matrix1Index++) {
				for (int transposeMatrixIndex = 0; transposeMatrixIndex < transposMatrix2.length; transposeMatrixIndex++) {
					if (matrix1[matrix1Index][1] == transposMatrix2[transposeMatrixIndex][1]) {
						int array[] = new int[3];
						array[0] = matrix1[matrix1Index][0];
						array[1] = transposMatrix2[transposeMatrixIndex][0];
						array[2] = transposMatrix2[transposeMatrixIndex][2] * matrix1[matrix1Index][2];
						resultList.add(array);
					}
				}
			}

			int[][] resultArray = new int[resultList.size()][3];

			for (int i = 0; i < resultArray.length; i++) {
				resultArray[i] = resultList.get(i);
			}

			int matrix3[][] = resultArray;
			int similarCount = 0;
			for (int index = 0; index < matrix3.length - 1; index++) {
				if (matrix3[index][0] == matrix3[index + 1][0]
						&& matrix3[index][1] == matrix3[index + 1][1]) {
					similarCount++;
				}
			}

			int addition[][] = new int[matrix3.length - similarCount][3];
			int additionIndex = 0;
			for (int matrix3Index = 0; matrix3Index < matrix3.length - 1; matrix3Index++, additionIndex++) {
				if (matrix3[matrix3Index][0] == matrix3[matrix3Index + 1][0]
						&& matrix3[matrix3Index][1] == matrix3[matrix3Index + 1][1]) {
					addition[additionIndex][0] = matrix3[matrix3Index][0];
					addition[additionIndex][1] = matrix3[matrix3Index][1];
					addition[additionIndex][2] = matrix3[matrix3Index][2]
							+ matrix3[matrix3Index + 1][2];
					matrix3Index++;
				} else {
					addition[additionIndex][0] = matrix3[matrix3Index][0];
					addition[additionIndex][1] = matrix3[matrix3Index][1];
					addition[additionIndex][2] = matrix3[matrix3Index][2];

					if (additionIndex == addition.length - 2) {
						addition[additionIndex + 1][0] = matrix3[matrix3Index + 1][0];
						addition[additionIndex + 1][1] = matrix3[matrix3Index + 1][1];
						addition[additionIndex + 1][2] = matrix3[matrix3Index + 1][2];

					}
				}
			}
			return new SparseMatrix(addition, totalRows1, totalColumns2);
		} else {
			throw new AssertionError("Multiplication is not possible");
		}
	}

/**
 * getting transpose of two matrix	
 * @return new sparse matrix which is transpose
 */
	public SparseMatrix transpose() {
		int array[][] = this.getSparse();

		for (int i = 0; i < array.length; i++) {
			int temp = array[i][0];
			array[i][0] = array[i][1];
			array[i][1] = temp;
		}

		return new SparseMatrix(array, this.getColumns(), this.getRows());
	}

	/**
	 * checking symmetry of two matrixes
	 * 
	 * @return
	 */
	public boolean checkSymmetrical() {
		boolean flag = true;
		int[][] matrix = this.getSparse();
		SparseMatrix trasnpose = this.transpose();
		int[][] transposeMatrix = trasnpose.getSparse();

		for (int i = 0; i < transposeMatrix.length; i++) {
			if (!Arrays.equals(transposeMatrix[i], matrix[i])) {
				flag = false;
			}
		}
		return flag;
	}
	
/**
 * merging two arrays 	
 * @param array1
 * @param array2
 * @return
 */
	private int[][] mergeArray(int array1[][], int array2[][]) {
		int i = 0;
		int j = 0;
		int array3[][] = new int[array1.length + array2.length][3];
		for (i = 0; i < array1.length; i++) {
			for (j = 0; j < array1[0].length; j++) {
				array3[i][j] = array1[i][j];
			}
		}
		for (int k = 0; k < array2.length; k++) {
			for (int l = 0; l < array2[0].length; l++) {
				array3[i][l] = array2[k][l];
			}
			i++;
		}
		return sort(array3);
	}

	public static void main(String aa[]) {
		int arr1[][]=new int[][]{{0,1,1},{0,2,3},{1,1,2},{1,2,5},{2,0,2}};
		int arr2[][]= new int[][]{{0,2,1},{1,0,3},{2,0,4},{2,1,1}};
		SparseMatrix m1 = new SparseMatrix(arr1, 3, 3);
		SparseMatrix m2 = new SparseMatrix(arr2, 3, 3);
		
		SparseMatrix m3 = m1.multiplySparse(m2);
		int arr3[][] = m3.getSparse();
		
		for(int i = 0; i<arr3.length;i++){
			System.out.println(Arrays.toString(arr3[i]));
		}




	}

}
