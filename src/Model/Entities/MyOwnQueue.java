package Model.Entities;

/**
 * ENTIRE CLASS USED BY ALDANA'S PROVIDED FILES IN THE CLASSES.
 *
 * @author aldan
 */
public class MyOwnQueue implements ArrayQueue {

    //PROPERTIES
    //data property String array
    private String[] data;
    //number of elements in my queue
    private int queueSize;
    //capacity of the queue.
    private int capacity;
    //index of the front element
    private int front;
    //index of the back element
    private int back;

    /**
     * Constructor requires a capacity to initiate class.
     *
     * @param capacity int value. Capacity of the queue.
     */
    public MyOwnQueue(int capacity) {
        //identifies the queue capacity.
        this.capacity = capacity;
        //creates a String array with the capacity and stores in data property.
        this.data = new String[capacity];
        //initialy queueSize is set to 0.
        this.queueSize = 0;
        //initially front element is set to -1.
        this.front = -1;
        //initially back element is set to -1.
        this.back = -1;
    }

    /**
     * Adds new element to queue.
     *
     * @param newElement String element.
     * @return Boolean for the added item status.
     */
    @Override
    public boolean enqueue(String newElement) {
        //queue size is equal or bigger than the capacity queue is full, and cannot add new items.
        if (queueSize >= capacity) {
            return false;
        }
        //if element is to add first element of the queue front is set to 0
        if (front == -1) {
            front++;
        }
        //increase back by 1
        back++;
        //data array back index is equal to new element to add queue.
        data[back] = newElement;
        //queue size increased by 1.
        queueSize++;
        return true;
    }

    /**
     * Removes element from the queue.
     *
     * @return String element removed from the queue.
     */
    @Override
    public String dequeue() {
        //checks if queue is empty (works for both approaches)
        if (queueSize == 0) {
            return null;
        }

        //approach 1
        //if qeueue has only an element.
        if (queueSize == 1) {
            // Element to return is front of the data 'index 0'
            String elementReturn = data[front];
            //front set -1.
            front--;
            //back is set -1.
            back--;
            //queue size is set 0.
            queueSize--;
            //element to remove returned.
            return elementReturn;
        }

        //Save the element in one variable (works for both approaches)
        String elementReturn = data[front];

        //approach 1
        /*
        Shifts all elements to one index lower and removes first element.
         */
        for (int i = 0; i < queueSize; i++) {
            if (i + 1 <= queueSize - 1) {
                data[i] = data[i + 1];
            }
        }
        //decrease back by 1
        back--;
        //decrease queue size by 1.
        queueSize--;
        //returns back the element to remove.
        return elementReturn;
    }

    /**
     * Gets first element of the queue.
     *
     * @return String
     */
    @Override
    public String first() {
        if (queueSize == 0) {
            return null;
        }
        return data[front];

    }

    /**
     * Gets last element of the queue.
     *
     * @return String.
     */
    @Override
    public String last() {
        if (queueSize == 0) {
            return null;
        }
        return data[back];
    }

    /**
     * Provides size of the queue.
     *
     * @return an integer value.
     */
    @Override
    public int size() {
        return queueSize;
    }

    /**
     * Check is the queue is empty or not.
     *
     * @return A boolean value.
     */
    @Override
    public boolean isEmpty() {
        if (queueSize == 0) {
            return true;
        }
        return false;
    }

    /**
     * Shows elements in the queue.
     *
     * @return String.
     */
    @Override
    public String toString() {
        String toReturn = "[ ";

        for (int i = front; i <= back; i++) {
            toReturn += data[i] + ", ";

        }
        toReturn += " ]";

        return toReturn;
    }

}
