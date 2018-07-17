/** stack2 class is implementing the stack in o(1) complexity 
 */

package stack2;
import java.util.*;

public class Stack2 {
	ListNode top;
	int size;
	static Scanner sc=new Scanner(System.in);


   /**
    * constructor for initializing the size and top
   */
	Stack2()
	{
		size=0;
		top=null;
	}

	/**
	 * check stack is empty or not
	 * @return true if empty else false
	*/
	
	boolean isEmpty(){
		if(size==0){
			return true;
		}else{
			return false;
		}

	}
	
	/**
	 * for pushing the elements in stack
	*/
	
	void push(){
		System.out.print("enter element to be pushed in stack: ");
		int inputElement = Stack2.sc.nextInt();
		ListNode temp = new ListNode(inputElement);
		if(size==0){
			top = temp;
			size+=1;
		}else{
			temp.next = top;
			top = temp;
			size+=1;

		}

	}
	
	/**
	 * for deleting the elements from stack
	*/

	void pop(){
		if(size==0){
			System.out.println("stack is empty");
		}else{
			System.out.print(top.data + " is popped");
			top = top.next;
			size--;
		}
	}
	
	/**
	 * printing the whole stack on console
	 */
	void traverse(){

		if(size==0){
			System.out.println("EMPTY STACK");
		}else{
			ListNode temp = top;
			while(temp!=null){
				System.out.println(temp.data);
				temp=temp.next;

			}
		}
	}
	
	/**
	 * shows the top most element of the stack
	*/
	void top(){
		if(size==0){
			System.out.println("EMPTY STACK ");
		}else{
			System.out.println(top.data);
		}
	}


	public static void main(String[] args) {
		int ch;
		Stack2 DynamicStack = new Stack2();


		while(true)
		{
			System.out.println("1. push");
			System.out.println("2. pop");
			System.out.println("3. top");
			System.out.println("4. traverse");
			System.out.println("5. quit");

			System.out.print("Enter The Input :");
			ch=Stack2.sc.nextInt();

			switch(ch)
			{
			case 1: DynamicStack.push();
			break;
			case 2: DynamicStack.pop();
			break;
			case 3: DynamicStack.top();
			break;
			case 4: DynamicStack.traverse();
			break;
			case 5: System.exit(1); 

			default: System.out.println("invalid choice");	                               
			}
		}


	}
}
