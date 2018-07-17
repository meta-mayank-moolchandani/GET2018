import java.util.*;
public class Stack2 {
	ListNode top;
	int size;
	static Scanner sc=new Scanner(System.in);
	
	class ListNode
	{
		ListNode next;
		int data;
		ListNode(int x){
			this.data = x;
			this.next=null;
		}
	}
	
	Stack2()
	{
		size=0;
		top=null;
	}
	
	boolean isEmpty(){
		if(size==0){
			return true;
		}else{
			return false;
		}
		
	}
	void push(){
		System.out.print("enter element to be pushed in stack: ");
	    int x = Stack2.sc.nextInt();
		ListNode temp = new ListNode(x);
		if(size==0){
			top = temp;
			size+=1;
		}else{
		   temp.next = top;
		   top = temp;
		   size+=1;
			
		}
		
	}
	
	void pop(){
		if(size==0){
			System.out.println("stack is empty");
		}else{
			System.out.print(top.data + " is popped");
			top = top.next;
			size--;
		}
	}
	
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
	
	void top(){
		if(size==0){
			System.out.println("EMPTY STACK ");
		}else{
			System.out.println(top.data);
		}
	}
	
	
    public static void main(String[] args) {
        int ch;
	   	Stack2 x = new Stack2();
	   	
	   	
	   	while(true)
	   	{
		   	System.out.println("1. push");
		   	System.out.println("2. pop");
		   	System.out.println("3. top");
		   	System.out.println("4. traverse");
		   	System.out.println("5. quit");
		   	
		   	System.out.print("Enter The Input :");
		   	ch=Stack1.sc.nextInt();
		   	
		   	switch(ch)
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
		   		
		   		default: System.out.println("invalid choice");	                               
		   	 }
	   }
	   
    	
    }
}
