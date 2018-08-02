package queueUsingArray;

public interface Queue {
	public boolean enqueue(int element);

	public boolean dequeue();

	public int peek();

	public boolean isEmpty();
	
	public boolean isFull();
	
	public int[] getQueue();
}
