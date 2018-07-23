package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetFix_xyArrayTest3 {

	@Test(expected = AssertionError.class)
	public void testGetFix_xyArray() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 1, 5, 2, 3, 4, 5, 4, 7, 4, 3 };
		arrayOperation1.setArray(test1);
		int expectedTest1[] = {};
		int[] actualTest1 = arrayOperation1.getFix_xyArray(4, 5);
		assertArrayEquals(expectedTest1, actualTest1);
	}

}
