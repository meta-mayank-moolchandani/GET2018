package sparseMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCheckSymmetrical {

	@Test
	public void testCheckSymmetrical() {
		int arr[][]=  new int[][]{{1,1,3},{2,2,5},{3,3,5}};
		SparseMatrix matrix = new SparseMatrix(arr, 4, 4);
		boolean result = matrix.checkSymmetrical();
         assertEquals(true, result);
	}
	
	@Test
	public void test2CheckSymmetrical() {
		int arr[][]=  new int[][]{{1,2,3},{2,2,5},{3,3,5}};
		SparseMatrix matrix = new SparseMatrix(arr, 4, 4);
		boolean result = matrix.checkSymmetrical();
         assertNotEquals(true, result);
	}




}
