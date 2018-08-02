package stackUsingArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTop {

	@Test
	public void test() {
			Stack stack = new StackArrayImp(5);
			stack.push(5);
			stack.push(4);
			stack.push(3);
			int actual = stack.top();
			assertEquals("top element is 3 in stack ",3, actual);
	}
	
	@Test
	public void test2() {
			Stack stack = new StackArrayImp(5);
			int actual = stack.top();
			assertEquals("no top element exists",-1, actual);
	}

}
