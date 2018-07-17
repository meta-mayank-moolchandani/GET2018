import java.util.*;

public class Stack1 {
	static Scanner sc = new Scanner(System.in);
	int stack[];
	int top = -1;

	/**
	 * constructor to take the input from user
	*/
	Stack1()
	{
		int size;
		System.out.print("Enter the size of stack: ");
		size = Stack1.sc.nextInt();
		stack=new int[size];
	}
	
	/**
	 * check stack is full or not
	 * @return true if full else false
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
	 * @return true if empty else false
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
	*/

	void push()
	{
		if(isFull()){
			System.out.println("stack is full");
		}else{
			System.out.print("enter element to be pushed in stack: ");
			int inputElement = Stack1.sc.nextInt();	
			stack[++top] =  inputElement;
		}

	}

	/**
	 * for deleting the elements from stack
	*/
	
	void pop(){
		if(isEmpty()){
			System.out.println("\nstack is empty");
		}else{
			//top = top - 1;
			System.out.println("\n" + stack[top--] + "is popped from stack");
		}
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
	 * printing the whole stack on console
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

		int choice;
		Stack1 x = new Stack1();

		while(true)
		{
			System.out.println("1. push");
			System.out.println("2. pop");
			System.out.println("3. top");
			System.out.println("4. traverse");
			System.out.println("5. quit");

			System.out.print("Enter The Input :");
			choice=Stack1.sc.nextInt();

			switch(choice)
			{
			  case 1: x.push();
			  break;
			  case 2: x.pop();
			  break;
			  case 3: x.top();
			  break;
			  case 4: x.traverse();
			  break;
			  case 5: System.exit(1);
			  break;

			  default: System.out.println("invalid choice");	                               
			}
		}       

	}
}
