package sparseMatrix;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAddition {

	@Test
	public void testAdd() {
		int arr1[][] = new int[][] { { 0, 0, 1 }, { 0, 3, 2 }, { 1, 0, 3 },
				{ 1, 2, 4 }, { 2, 2, 5 } };
		SparseMatrix matrix1 = new SparseMatrix(arr1, 4, 4);

		int arr2[][] = new int[][] { { 0, 1, 3 }, { 0, 3, 4 }, { 1, 3, 5 },
				{ 2, 2, 6 } };
		SparseMatrix matrix2 = new SparseMatrix(arr2, 4, 4);

		int result[][] = matrix1.Add(matrix2).getSparse();
		int expected[][] = new int[][] { { 0, 0, 1 }, { 0, 1, 3 }, { 0, 3, 6 },
				{ 1, 0, 3 }, { 1, 2, 4 }, { 1, 3, 5 }, { 2, 2, 11 } };

		assertArrayEquals("addition of two matrixes", expected, result);
	}

	@Test
	public void test2Add() {
		int arr1[][] = new int[][] { { 0, 2, 1 }, { 0, 3, 2 } };
		SparseMatrix matrix1 = new SparseMatrix(arr1, 4, 4);

		int arr2[][] = new int[][] { { 0, 1, 3 }, { 0, 3, 4 } };
		SparseMatrix matrix2 = new SparseMatrix(arr2, 4, 4);

		int result[][] = matrix1.Add(matrix2).getSparse();
		int expected[][] = new int[][] { { 0, 1, 3 }, { 0, 2, 1 }, { 0, 3, 6 } };
		assertArrayEquals("addition of two matrixes", expected, result);
	}

	@Test
	public void test3Add() {
		int arr1[][] = new int[][] { { 0, 0, 2 } };
		SparseMatrix matrix1 = new SparseMatrix(arr1, 4, 4);

		int arr2[][] = new int[][] { { 0, 0, 5 } };
		SparseMatrix matrix2 = new SparseMatrix(arr2, 4, 4);

		int result[][] = matrix1.Add(matrix2).getSparse();
		int expected[][] = new int[][] { { 0, 0, 7 } };
		assertArrayEquals("addition of two matrixes", expected, result);
	}

}
