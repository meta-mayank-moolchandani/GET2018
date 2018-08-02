package stackUsingArray;

public interface Stack {

	public int[] getStack();

	public boolean push(int element);

	public boolean pop();

	public int top();

	public boolean isEmpty();

	public boolean isFull();
}
