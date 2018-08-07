package circularQueue;

import static org.junit.Assert.*;

import org.junit.Test;


public class QueueTest {
    @Test
    public void testForEmpty() {
        CircularQueue.rear = -1;
        CircularQueue.front = -1;
        Queue queue = new CircularQueue();

        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testForFull() {

        Queue queue = new CircularQueue();

        CircularQueue.queue = new int[] { 1, 2, 3, 4, 5, 6 };
        CircularQueue.rear = CircularQueue.queue.length - 1;
        CircularQueue.front = 0;
        assertEquals(true, queue.isFull());
    }
} 

