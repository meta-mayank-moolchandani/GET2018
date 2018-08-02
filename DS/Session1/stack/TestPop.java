package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPop {

	@Test
	public void testPop() {
		Stack<Integer> stack = new StackLinklist<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.pop();
		Object[] actual = stack.getStack();
		Integer[] expected = new Integer[] { 4,5 };
		assertArrayEquals("element 3 is popped successfully",expected, actual);
	}

	@Test
	public void test2Pop() {
		Stack<Integer> stack = new StackLinklist<Integer>();
		boolean actual = stack.pop();
		assertEquals("pop returns false if there is no such element exists",false, actual);
	}

}
