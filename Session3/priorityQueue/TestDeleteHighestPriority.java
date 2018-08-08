package priorityQueue;

import static org.junit.Assert.*;


import org.junit.Test;

public class TestDeleteHighestPriority {

	@SuppressWarnings("unchecked")
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

		priorityQueue.deleteHighestPriority();

		int arrayOfIntegerAvailableInItems[] = new int[priorityQueue.getQueue().length];
		int index = 0;
		for (Item<Integer> item : priorityQueue.getQueue()) {
			arrayOfIntegerAvailableInItems[index] = item.getItem();
			index++;
		}
		int expectedResult[] = new int[] { 7, 1, 5 };
		assertArrayEquals(
				"highest priority will be deleted if two elements have same highest priority then element will be deleted on the basis of first come first serve basis",
				expectedResult, arrayOfIntegerAvailableInItems);
	}
}
