import java.util.*;

public class Stack3 {
   static Scanner sc = new Scanner(System.in);
   char stack[];
   int top = -1;
   
   Stack3(int size)
   {
   	//size = Stack1.sc.nextInt();
   	stack=new char[size];
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
    
    void push(char ch)
    {
    	if(isFull()){
    		System.out.println("stack is full");
    	}else{
	    	//System.out.print("enter element to be pushed in stack: ");
	    		
	    	stack[++top] =  ch;
    	}
    	
    }
    
    char pop(){
    	    //top = top - 1;
    		return stack[top--];
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
    	
    	String s = new String();
    	s = sc.next();
   	    System.out.print(s);
   	    char arr[] = s.toCharArray();

        Stack3 x = new Stack3(arr.length);
        
        for(int i = 0; i < arr.length; i++){
        	x.push(arr[i]);
        }
        String ss = "";
        
        for(int i = 0 ; i<arr.length; i++){
        	ss=ss+x.pop();
        }
        
        if(ss.equals(s)){
        	System.out.println("\n\npalindrome");
        }else{
        	System.out.println("not palindrome");
        }
           	    


	    
  }
}
