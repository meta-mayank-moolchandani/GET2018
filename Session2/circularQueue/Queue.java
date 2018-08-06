package circularQueue;

//Interface for Queue

public interface Queue {

    void enqueue(int element);
    void dequeue();
    boolean isEmpty();
    boolean isFull();

}
