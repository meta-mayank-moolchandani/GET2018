package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetClumpsTest4 {
	/**
	 * test4 for a single element in an array
	 */
	@Test
	public void testGetClumps() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 1 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = -1;
		int actualTest1 = arrayOperation1.getClumps();
		assertEquals(expectedTest1, actualTest1);

	}

}
