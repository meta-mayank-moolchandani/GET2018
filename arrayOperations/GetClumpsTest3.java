package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetClumpsTest3 {
	/**
	 * test 3 for empty array throws assertion error
	 */
	@Test(expected = AssertionError.class)
	public void testGetClumps() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] {};
		arrayOperation1.setArray(test1);
		int expectedTest1 = 1;
		int actualTest1 = arrayOperation1.getClumps();
		assertEquals(expectedTest1, actualTest1);

	}

}
