package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetFix_xyArrayTest5 {

	@Test()
	public void testGetFix_xyArray() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 1, 4, 1, 5, 5, 4, 1 };
		arrayOperation1.setArray(test1);
		int expectedTest1[] = { 1, 4, 5, 1, 1, 4, 5 };
		int[] actualTest1 = arrayOperation1.getFix_xyArray(4, 5);
		assertArrayEquals(expectedTest1, actualTest1);
	}
}
