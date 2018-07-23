package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitArrayTest2 {

	/**
	 * testing the input {0,0,0,0,0}
	 */
	@Test(expected = AssertionError.class)
	public void testSplitArray() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 0, 0, 0, 0, 0 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = 1;
		int actualTest1 = arrayOperation1.splitArray();
		assertEquals(expectedTest1, actualTest1);
	}

}
