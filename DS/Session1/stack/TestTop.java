package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTop {

	@Test
	public void test() {
		Stack<Integer> stack = new StackLinklist<Integer>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		int actual  = 3;
		assertEquals("top element is 3 in stack ",(int)stack.top(), actual);
	}
	
	@Test
	public void test2() {
		Stack<Integer> stack = new StackLinklist<Integer>();
			assertEquals("no top element exists", null,stack.top());
	}

}
