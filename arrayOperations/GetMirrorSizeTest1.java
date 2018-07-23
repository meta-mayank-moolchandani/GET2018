package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetMirrorSizeTest1 {

	@Test
	public void testGetMirrorSize() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 1, 2, 3, 4, 2, 1, 1, 3, 3, 5, 3, 3, 1, 7 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = 7;
		int actualTest1 = arrayOperation1.getMirrorSize();
		// System.out.println(actualTest1);
		assertEquals(expectedTest1, actualTest1);

	}

}
