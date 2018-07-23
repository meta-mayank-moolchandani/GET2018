package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class SplitArrayTest5 {

	/**
	 * testing the input { -10, -20, 100, 40, 30 }
	 */
	@Test
	public void testSplitArray() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { -10, -20, 100, 40, 30 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = 3;
		int actualTest1 = arrayOperation1.splitArray();
		assertEquals(expectedTest1, actualTest1);
	}


}
