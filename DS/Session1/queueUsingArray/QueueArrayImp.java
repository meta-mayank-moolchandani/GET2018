package queueUsingArray;

public class QueueArrayImp implements Queue {
	private int queue[];
	private int size;
	int index = 0;

	QueueArrayImp(int size) {
		index = 0;
		this.size = size;
		queue = new int[size];
	}

	/**
	 * inserting an element to queue
	 */
	@Override
	public boolean enqueue(int element) {
		boolean flag = false;
		if (!isFull()) {
			queue[index] = element;
			index++;
			flag = true;
		}
		return flag;
	}

	/**
	 * deleting element from queue
	 */
	@Override
	public boolean dequeue() {
		boolean flag = false;
		if (!isEmpty()) {
			for (int i = 0; i < this.index - 1; i++) {
				queue[i] = queue[i + 1];
			}
			this.index--;
			flag = true;
		}
		return flag;
	}

	/**
	 * returns the first element o queue
	 */
	@Override
	public int peek() {
		return isEmpty() ? -1 : queue[0];
	}

	/**
	 * returns true if queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return index == 0 ? true : false;
	}

	/**
	 * returns the array of queue
	 */
	@Override
	public int[] getQueue() {
		int array[] = new int[index];
		for (int i = 0; i < array.length; i++) {
			array[i] = queue[i];
		}
		return array;
	}

	public boolean isFull() {
		return index == size ? true : false;
	}

}
