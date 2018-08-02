package queue;

import java.util.Arrays;

public class JaiBhawani {

	public static void main(String args[]) {
		QueueLinklist<Object> s = new QueueLinklist<Object>();
		s.enqueue(2);
		s.enqueue('a');
		s.enqueue("HELLO");
		s.enqueue(2.20);
		s.enqueue("!");
		
		System.out.println(Arrays.toString(s.getQueue()));
		

		System.out.println(s.peek());
		System.out.println(s.dqueue());
		System.out.println(Arrays.toString(s.getQueue()));
        System.out.println();
		
        System.out.println(s.peek());
		System.out.println(s.dqueue());
		System.out.println(Arrays.toString(s.getQueue()));
        System.out.println();

		System.out.println(Arrays.toString(s.getQueue()));
        System.out.println();
		System.out.println(s.peek());
		System.out.println(s.dqueue());

		System.out.println(s.peek());
		System.out.println(s.dqueue());
		System.out.println(Arrays.toString(s.getQueue()));
        System.out.println();

		System.out.println(s.peek());
		System.out.println(s.dqueue());
		System.out.println(Arrays.toString(s.getQueue()));
        System.out.println();

		System.out.println(s.peek());
		System.out.println(s.dqueue());
		System.out.println(Arrays.toString(s.getQueue()));
        System.out.println();

	}

}
