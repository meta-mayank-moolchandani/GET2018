package priorityQueue;

public class Item<T> {
	private T item;
	private int priority;

	/**
	 * @return the item
	 */
	public T getItem() {
		return item;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	public Item(T item, int priority) {
		this.item = item;
		this.priority = priority;
	}
}
