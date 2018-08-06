package circularQueue;

import static org.junit.Assert.*;

import org.junit.Test;


public class QueueTest {

    /**
     * Helper function to check wether the element exist in the queue which is
     * entered or not
     * 
     * @param element
     * @return true or false
     */
    boolean checkElementinQueue(int element, int queue[], int front) {

        for (int i = front; i < queue.length; i++) {
            if (element == queue[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function to test if element is added in the queue
     */
    @Test
    public void testForAddElement() {

        Queue queue = new circularQueue();
        circularQueue.queue = new int[4];
        int element = 4;
        queue.addElement(element);

        int queueArray[] = circularQueue.queue;
        int front = circularQueue.front;
        assertEquals(true, this.checkElementinQueue(element, queueArray, front));
    }

    @Test
    public void testForEmpty() {
        circularQueue.rear = -1;
        circularQueue.front = -1;
        Queue queue = new circularQueue();

        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testForFull() {

        Queue queue = new circularQueue();

        circularQueue.queue = new int[] { 1, 2, 3, 4, 5, 6 };
        circularQueue.rear = circularQueue.queue.length - 1;
        circularQueue.front = 0;
        assertEquals(true, queue.isFull());
    }

    @Test
    public void testForRemoveElement() {

        Queue queue = new circularQueue();
        circularQueue.queue = new int[] { 1, 2, 3 };
        circularQueue.rear = 3;

        queue.removeElement();
        int front = circularQueue.front;
        boolean actual = this
                .checkElementinQueue(1, circularQueue.queue, front);

        assertEquals(false, actual);
    }

}
