package queueUsingArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDequeue {

	@Test
	public void testDqueue() {
		QueueArrayImp queue = new QueueArrayImp(5);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(3);
		queue.enqueue(2);
		
		queue.dequeue();
		int[] actualResult = queue.getQueue();
		
		assertArrayEquals("dequeueing elements are done", new int[] { 4, 3,
				2 }, actualResult);
	}
	
	@Test
	public void test1Dqueue() {
		QueueArrayImp queue = new QueueArrayImp(5);
		
		boolean actualResult = queue.dequeue();
		assertEquals("element has not added as queue is full", false,
				actualResult);		
	
	}


}
