package stackUsingArray;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestPush {

	@Test
	public void testPush() {
		Stack stack = new StackArrayImp(5);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		int[] actual = stack.getStack();
		int[] expected = new int[] { 5, 4, 3 };
		assertArrayEquals("elements are pushed successfully",expected, actual);
	}

	@Test
	public void test2Push() {
		Stack stack = new StackArrayImp(5);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		boolean actual = stack.push(5);

		assertEquals("element 5 can not be pushed as queue was full",false, actual);
	}

}
