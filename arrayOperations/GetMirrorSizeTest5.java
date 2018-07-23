package arrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetMirrorSizeTest5 {

	@Test(expected = AssertionError.class)
	public void test() {
		ArrayOperations arrayOperation1 = new ArrayOperations();
		int test1[] = new int[] {};
		arrayOperation1.setArray(test1);
		int expectedTest1 = 7;
		int actualTest1 = arrayOperation1.getMirrorSize();
		assertEquals(expectedTest1, actualTest1);

	}

}
