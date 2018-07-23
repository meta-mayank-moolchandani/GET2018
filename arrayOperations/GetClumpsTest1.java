package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetClumpsTest1 {
	/**
	 * test for { 1, 2, 2, 3, 4, 4 }
	 */
	@Test
	public void testGetClumps() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 1, 2, 2, 3, 4, 4 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = 2;
		int actualTest1 = arrayOperation1.getClumps();
		assertEquals(expectedTest1, actualTest1);

	}

}
