package sparseMatrix;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestMultiply {

	@Test
	public void testMultiplySparse() {

		int arr1[][] = new int[][] { { 0, 1, 1 }, { 0, 2, 3 }, { 1, 1, 2 },
				{ 1, 2, 5 }, { 2, 0, 2 } };
		SparseMatrix matrix1 = new SparseMatrix(arr1, 4, 4);

		int arr2[][] = new int[][] { { 0, 2, 1 }, { 1, 0, 3 }, { 2, 0, 4 },
				{ 2, 1, 1 } };
		SparseMatrix matrix2 = new SparseMatrix(arr2, 4, 4);

		int result[][] = matrix1.multiplySparse(matrix2).getSparse();
		int expected[][] = new int[][] { { 0, 0, 15 }, { 0, 1, 3 },
				{ 1, 0, 26 }, { 1, 1, 5 }, { 2, 2, 2 } };

		assertArrayEquals("multiplication of two matrixes", expected, result);
	}

	@Test
	public void test2MultiplySparse() {

		int arr1[][] = new int[][] { { 0, 2, 3 }, { 1, 1, 1 }, { 2, 0, 1 } };
		SparseMatrix matrix1 = new SparseMatrix(arr1, 4, 4);

		int arr2[][] = new int[][] { { 0, 1, 1 }, { 2, 0, 1 }, { 1, 1, 1 } };
		SparseMatrix matrix2 = new SparseMatrix(arr2, 4, 4);
		int result[][] = matrix1.multiplySparse(matrix2).getSparse();

		for (int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}

		int expected[][] = new int[][] { { 0, 0, 3 }, { 1, 1, 1 }, { 2, 1, 1 } };

		assertArrayEquals("multiplication of two matrixes", expected, result);
	}
}
