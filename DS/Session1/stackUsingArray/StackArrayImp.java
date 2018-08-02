package stackUsingArray;

public class StackArrayImp implements Stack {
	private int[] stack;
	private int top;
	private int size;

	public StackArrayImp(int size) {
		top = -1;
		this.size = size;
		stack = new int[size];
	}

	/**
	 * getting existing element's array from stack
	 */
	@Override
	public int[] getStack() {
		if (top != -1) {
			int temp[] = new int[top + 1];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = stack[i];
			}
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * pushing elements in stack
	 */
	@Override
	public boolean push(int element) {
		boolean flag = false;
		if (!isFull()) {
			stack[top + 1] = element;
			top++;
			flag = true;
		}
		return flag;
	}

	/**
	 * deleting the element from the stack
	 */
	@Override
	public boolean pop() {
		boolean flag = false;
		if (!isEmpty()) {
			top--;
			flag = true;
		}
		return flag;
	}

	/**
	 * returns the top element of the stack
	 */
	@Override
	public int top() {
		if (top == -1) {
			return -1;
		} else {
			return stack[top];
		}
	}

	/**
	 * true if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return (top == -1) ? true : false;
	}

	/**
	 * true if stack is full
	 */
	@Override
	public boolean isFull() {
		return (top == size - 1) ? true : false;
	}

}
