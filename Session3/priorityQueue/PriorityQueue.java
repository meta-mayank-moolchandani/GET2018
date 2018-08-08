package priorityQueue;

public class PriorityQueue<T> {
	private Item<T> queue[];
	private int size;
	private int index;

	@SuppressWarnings("unchecked")
	public PriorityQueue(int size) {
		this.size = size;
		queue = new Item[size];
		index = -1;
	}

	/**
	 * for adding an item in queuue
	 * 
	 * @param item
	 * @return
	 */
	public boolean enqueue(Item<T> item) {
		boolean flag = false;
		if (!isFull()) {
			index++;
			queue[index] = item;
			flag = true;
		}
		return flag;
	}

	/**
	 * getting the highest priority
	 * 
	 * @return
	 */
	public Item<T> getHighestPriority() {
		int maximumPriorityIndex = 0;
		if (!isEmpty()) {
			int maximumPriority = queue[0].getPriority();
			// maximum priority is the minimum
			// value
			// of the priority in the item list
			for (int i = 1; i <= index; i++) {
				if (queue[i].getPriority() < maximumPriority) {
					maximumPriority = queue[i].getPriority();
					maximumPriorityIndex = i;
				}
			}
		}
		return queue[maximumPriorityIndex];
	}

	/**
	 * deleting highest priority
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteHighestPriority() {
		boolean flag = false;

		try {
			if (!isEmpty()) {
				int maximumPriority = queue[0].getPriority();
				int maximumPriorityIndex = 0; // maximum priority is the minimum
												// value
												// of the priority in the item
												// list
				for (int i = 1; i <= index; i++) {
					if (queue[i].getPriority() < maximumPriority) {
						maximumPriority = queue[i].getPriority();
						maximumPriorityIndex = i;
					}
				}

				Item<T> newQueue[];
				newQueue = new Item[size];
				int queueIndex = 0;
				int newQueueIndex = 0;
				while (queueIndex <= index) {
					if (queueIndex == maximumPriorityIndex) {
						queueIndex++;
					} else {
						newQueue[newQueueIndex] = queue[queueIndex];
						queueIndex++;
						newQueueIndex++;
					}
				}
				if (newQueueIndex == index) {
					flag = true;
					queue = newQueue;
					index--;
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;

	}

	/**
	 * getting array of Item which are currently present in queue
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Item[] getQueue() {

		Item<T> getQueue[] = new Item[index + 1];
		// getQueue = new Item[index + 1];
		for (int i = 0; i < getQueue.length; i++) {
			getQueue[i] = queue[i];
		}
		return getQueue;
	}

	private boolean isEmpty() {
		return (index == -1) ? true : false;
	}

	private boolean isFull() {
		return (index == size) ? true : false;
	}

}
