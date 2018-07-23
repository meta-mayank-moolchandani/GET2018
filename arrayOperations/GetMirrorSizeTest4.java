package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetMirrorSizeTest4 {

	@Test
	public void testGetMirrorSize() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] { 1, 1, 1, 1, 1, 1, 1 };
		arrayOperation1.setArray(test1);
		int expectedTest1 = 7;
		int actualTest1 = arrayOperation1.getMirrorSize();
		assertEquals(expectedTest1, actualTest1);

	}

}
