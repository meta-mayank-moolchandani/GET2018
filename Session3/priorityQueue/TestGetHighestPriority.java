package priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGetHighestPriority {

	@Test
	public void test() {
		Item<Integer> item1 = new Item<Integer>(1, 10);
		Item<Integer> item2 = new Item<Integer>(3, 1);
		Item<Integer> item4 = new Item<Integer>(5, 1);

		Item<Integer> item3 = new Item<Integer>(7, 5);

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(10);

		priorityQueue.enqueue(item3);
		priorityQueue.enqueue(item2);
		priorityQueue.enqueue(item1);
		priorityQueue.enqueue(item4);

//		priorityQueue.deleteHighestPriority();
	
		
		int actualResult = priorityQueue.getHighestPriority().getItem();
		System.out.println(actualResult);
		assertEquals("Item 2 has served as highest priority as it came first into the queue",3, actualResult);

	}
	
	public void test2() {
		Item<Integer> item1 = new Item<Integer>(1, 10);
		Item<Integer> item2 = new Item<Integer>(3, 1);
		Item<Integer> item4 = new Item<Integer>(5, 1);

		Item<Integer> item3 = new Item<Integer>(7, 5);

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(10);

		priorityQueue.enqueue(item3);
		priorityQueue.enqueue(item2);
		priorityQueue.enqueue(item1);
		priorityQueue.enqueue(item4);

		priorityQueue.deleteHighestPriority();
	
		
		int actualResult = priorityQueue.getHighestPriority().getItem();
		System.out.println(actualResult);
		assertEquals("Item 4 has served as highest priority as item 3 is removed from the queue",5, actualResult);

	}

}
