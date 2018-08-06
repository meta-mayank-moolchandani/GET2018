package circularQueue;

public class circularQueue implements Queue {

    public static int queue[];
    public static int front = -1;
    public static int rear = -1;


    /**
     * Function to check if the queue is full
     * 
     * @return true if queue is full
     */
    public boolean isFull() {
        boolean flag = false;
        if ((front == rear + 1)
                || (front == 0 && rear == queue.length - 1)) {
            flag = true;
        }
        return flag;
    }

    /**
     * Function to check if the queue is empty
     * 
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        boolean flag = false;
        if (front == -1 && rear == -1) {
            flag = true;
        }
        return flag;
    }

    /**
     * Function to push an elements in the queue
     */
    public void addElement(int element) {

        if (isEmpty()) {
            front = 0;
            rear = 0;
            queue[rear] = element;

        } else {
            if (isFull()) {
                System.out.println("!!Stack Overflow!!");
            }
            if (rear == queue.length - 1) {
                rear = 0;
            } else {
                rear = rear + 1;
            }
            queue[rear] = element;
        }
    }

    /**
     * Function to delete an element from queue
     */
    public void removeElement() {
        if (isEmpty()) {
            System.out.println("!!Stack Underflow!!");
        } else if (front == rear) {
            front = rear = -1;

        } else {
            if (front == queue.length - 1) {
                front = 0;

            } else {
                front++;
            }
        }
    }

    /**
     * Function to display elements of queue and return count
     */

    public int show() {
        int count = 0;
        System.out.println("\nElements in queue are:");
        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i]);
            count++;
        }
        return count;
    }
}
