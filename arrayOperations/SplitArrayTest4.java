package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitArrayTest4 {
/**
 * for testing an empty array
 */
	@Test(expected = AssertionError.class)
	public void testSplitArray() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] {};
		arrayOperation1.setArray(test1);
		int expectedTest1 = 1;
		int actualTest1 = arrayOperation1.splitArray();
		assertEquals(expectedTest1, actualTest1);
	}

}
