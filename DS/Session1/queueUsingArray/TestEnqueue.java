package queueUsingArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEnqueue {

	@Test
	public void testEnqueue() {
		QueueArrayImp queue = new QueueArrayImp(5);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(3);
		queue.enqueue(2);
		int[] actualResult = queue.getQueue();
		assertArrayEquals("enqueueing elements are done", new int[] { 5, 4, 3,
				2 }, actualResult);
	}

	@Test
	public void test2Enqueue() {
		QueueArrayImp queue = new QueueArrayImp(5);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(3);
		queue.enqueue(2);
		queue.enqueue(1);
		boolean actualResult = queue.enqueue(50);
		assertEquals("element has not added as queue is full", false,
				actualResult);

	}

}
