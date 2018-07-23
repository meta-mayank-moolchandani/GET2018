package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetClumpsTest2 {
	/**
	 * test2 for { 1,2,2,3,4,5,6,6,6,7,89,89,89 }
	 */
	@Test
	public void testGetClumps() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 1, 2, 2, 3, 4, 5, 6, 6, 6, 7, 89, 89, 89 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = 3;
		int actualTest1 = arrayOperation1.getClumps();
		assertEquals(expectedTest1, actualTest1);

	}

}
