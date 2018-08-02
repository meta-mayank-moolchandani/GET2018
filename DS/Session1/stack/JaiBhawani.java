package stack;

import java.util.Arrays;

public class JaiBhawani {
	
	public static void main(String args[]){
		StackLinklist<Integer> s= new StackLinklist<Integer>();
		s.push(2);
		s.push((int)'a');
		s.push(3);
		
		System.out.println(Arrays.toString(s.getStack()));
		
		System.out.println(s.top());
		System.out.println(s.pop());

		System.out.println(s.top());
		System.out.println(s.pop());
		
		System.out.println(s.top());
		System.out.println(s.pop());
		
/*		System.out.println(s.top());
		System.out.println(s.pop());
		System.out.println(s.top());
*/	}

}
