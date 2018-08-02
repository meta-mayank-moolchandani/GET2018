package stackUsingArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPop {

	@Test
	public void testPop() {
		Stack stack = new StackArrayImp(5);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.pop();
		int[] actual = stack.getStack();

		int[] expected = new int[] { 5, 4 };
		assertArrayEquals("element 3 is popped successfully",expected, actual);
	}

	@Test
	public void test2Pop() {
		Stack stack = new StackArrayImp(5);
		boolean actual = stack.pop();
		assertEquals("pop returns false if there is no such element exists",false, actual);
	}

}
