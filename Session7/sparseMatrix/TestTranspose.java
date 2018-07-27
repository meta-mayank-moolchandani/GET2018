package sparseMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTranspose {

	@Test
	public void testTranspose() {
		int arr[][]=  new int[][]{{0,1,3},{2,1,2},{2,2,5}};
		SparseMatrix matrix = new SparseMatrix(arr, 3, 3);
		SparseMatrix transpose = matrix.transpose();
		int result[][] = transpose.getSparse();
		int expected[][]=new int[][]{{1,0,3},{1,2,2},{2,2,5}};
		
		assertArrayEquals(expected, result);
	}
	

	@Test
	public void test1Transpose() {
		int arr[][]=  new int[][]{{0,2,3},{1,3,2}};
		SparseMatrix matrix = new SparseMatrix(arr, 4, 4);
		SparseMatrix transpose = matrix.transpose();
		int result[][] = transpose.getSparse();
		int expected[][]=new int[][]{{2,0,3},{3,1,2}};
		
		assertArrayEquals(expected, result);
	}

	
	@Test
	public void test2Transpose() {
		int arr[][]=  new int[][]{{0,1,1},{2,5,2}};
		SparseMatrix matrix = new SparseMatrix(arr, 6, 6);
		SparseMatrix transpose = matrix.transpose();
		int result[][] = transpose.getSparse();
		int expected[][]=new int[][]{{1,0,1},{5,2,2}};
		
		assertArrayEquals(expected, result);
	}


}
