import java.util.*;

public class Stack1 {
   static Scanner sc = new Scanner(System.in);
   int stack[];
   int top = -1;
   
   Stack1()
   {
   	int size;
   	System.out.print("Enter the size of stack: ");
   	size = Stack1.sc.nextInt();
   	stack=new int[size];
   }
   
   boolean isFull()
   {
	  if(top==stack.length-1)
	   	return true;
	  else
	    return false;
   }
   
   boolean isEmpty()
   	{
   	if(top==-1)
   		return true;
   	else
   		return false;
    }
    
    void push()
    {
    	if(isFull()){
    		System.out.println("stack is full");
    	}else{
	    	System.out.print("enter element to be pushed in stack: ");
	    	int x = Stack1.sc.nextInt();	
	    	stack[++top] =  x;
    	}
    	
    }
    
    void pop(){
    	if(isEmpty()){
    		System.out.println("\nstack is empty");
    	}else{
    		//top = top - 1;
    		System.out.println("\n" + stack[top--] + "is popped from stack");
    	}
    }
    
    void top(){
    	if(isEmpty()){
    		System.out.println("\nstack is empty");
    	}else{
    		System.out.println("top element is : " + stack[top]);
    	}
    }
    
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
   	    
	   	int ch;
	   	Stack1 x = new Stack1();
	   	
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
