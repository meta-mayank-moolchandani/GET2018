package stack;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	public ListNode<T> previous;

	public ListNode(T data) {
		this.data = data;
		next = null;
		previous = null;
	}
}
