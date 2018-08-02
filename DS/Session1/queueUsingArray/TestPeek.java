package queueUsingArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPeek {

	@Test
	public void testPeek() {
		QueueArrayImp queue = new QueueArrayImp(5);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(3);
		int actualResult = queue.peek();
		assertEquals("peek element is 5",5, actualResult);
	}
	
	@Test
	public void test2Peek() {
		QueueArrayImp queue = new QueueArrayImp(5);
		assertEquals("peek element does not exist",-1, queue.peek());
	}


}
