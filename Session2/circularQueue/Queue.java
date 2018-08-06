package circularQueue;

//Interface for Queue

public interface Queue {

    /**
     * Function to add element in queue
     * 
     * @param element
     */
    void addElement(int element);

    /**
     * Function to remove element
     * 
     * @param element
     */
    void removeElement();

    boolean isEmpty();

    boolean isFull();

}
