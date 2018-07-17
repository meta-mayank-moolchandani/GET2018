/*checking palindrome using stack
*/

import java.util.*;



public class Stack3 {
	static Scanner sc = new Scanner(System.in);
	char stack[];
	int top = -1;
    
	/**
	 * constructor to create static array named as stack
	 * @param size is the size of the stack
	 */
	Stack3(int size)
	{
		//size = Stack1.sc.nextInt();
		stack=new char[size];
	}
	
	/**
	 * check stack is full or not
	 * @return true if stack is full else false
	*/
	boolean isFull()
	{
		if(top==stack.length-1)
			return true;
		else
			return false;
	}

	/**
	 * check stack is empty or not
	 * @return true if stack is empty else false
	*/
	boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	
	/**
	 * for pushing the elements in stack
	 * @param element is the character to which is need to be pushed
	*/
    void push(char element)
	{
		if(isFull()){
			System.out.println("stack is full");
		}else{
			//System.out.print("enter element to be pushed in stack: ");

			stack[++top] =  element;
		}

	}

    /**
	 * for deleting the elements from stack
	 * @return the top element of stack
	*/
	char pop(){
		//top = top - 1;
		return stack[top--];
	}
	
	/**
	 * shows the top most element of the stack
	*/
	void top(){
		if(isEmpty()){
			System.out.println("\nstack is empty");
		}else{
			System.out.println("top element is : " + stack[top]);
		}
	}
	
	/**
	 * for printing whole stack on console.
	 */

	void traverse(){
		if(isEmpty()){
			System.out.println("\nstack is empty");
		}else{
			for(int i=0;i<=top;i++){
				System.out.println(stack[top-i]);
			}
		}
	}

	public static void main(String[] args) {
		String input = new String();
		input = sc.next();
		System.out.print(input);
		char inputArray[] = input.toCharArray();

		Stack3 x = new Stack3(inputArray.length);

		for(int i = 0; i < inputArray.length; i++){
			x.push(inputArray[i]);
		}
		String reverseString = "";

		for(int i = 0 ; i<inputArray.length; i++){
			reverseString=reverseString+x.pop();
		}

		if(reverseString.equals(input)){
			System.out.println("\n\npalindrome");
		}else{
			System.out.println("not palindrome");
		}




	}
}
