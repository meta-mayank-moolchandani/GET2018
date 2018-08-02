package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPush {

	@Test
	public void testPush() {
		Stack<Integer> stack = new StackLinklist<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		
		Object[] actual = stack.getStack();
		Integer[] expected = new Integer[] {3,4,5};
		assertArrayEquals("elements are pushed successfully",expected, actual);
	}

}
