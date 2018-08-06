package circularQueue;

public class CircularQueue implements Queue {

	public static int queue[];
	public static int front = -1;
	public static int rear = -1;

	/**
	 * Function to check if the queue is full
	 * 
	 * @return true if queue is full
	 */
	public boolean isFull() {
		boolean flag = false;
		if ((front == rear + 1) || (front == 0 && rear == queue.length - 1)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to check if the queue is empty
	 * 
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		boolean flag = false;
		if (front == -1 && rear == -1) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Function to push an elements in the queue
	 */
	public void enqueue(int element) {

		if (isEmpty()) {
			front = 0;
			rear = 0;
			queue[rear] = element;

		} else if (!isFull()) {
			if (rear == queue.length - 1) {
				rear = 0;
			} else {
				rear += 1;
			}
			queue[rear] = element;
		}

	}

	/**
	 * Function to delete an element from queue
	 */
	public void dequeue() {
		if (!isEmpty()) {
			if (front == rear) {
				front = rear = -1; // when queue has only one elemet
			} else {
				if (front == queue.length - 1) {
					front = 0;
				} else {
					front++;
				}
			}
		}
	}
	
}
