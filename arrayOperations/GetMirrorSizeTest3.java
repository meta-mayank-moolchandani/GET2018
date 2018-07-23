package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetMirrorSizeTest3 {

	@Test
	public void testGetMirrorSize() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { -1, -4, 7, 8, 9, -4, -1, 10, 11 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = 2;
		int actualTest1 = arrayOperation1.getMirrorSize();
		assertEquals(expectedTest1, actualTest1);

	}

}
