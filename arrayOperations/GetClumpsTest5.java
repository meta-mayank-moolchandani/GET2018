package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetClumpsTest5 {
	/**
	 * test 5 {0,0,0,0,0,0,0}
	 */
	@Test
	public void testGetClumps() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = 1;
		int actualTest1 = arrayOperation1.getClumps();
		assertEquals(expectedTest1, actualTest1);

	}

}
