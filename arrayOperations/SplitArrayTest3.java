package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitArrayTest3 {
	/**
	 * testing the input {1,2,3,4,5}
	 */
	@Test
	public void testSplitArray() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 1, 2, 3, 4, 5 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = -1;
		int actualTest1 = arrayOperation1.splitArray();
		assertEquals(expectedTest1, actualTest1);
	}

}
