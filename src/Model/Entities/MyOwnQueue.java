package Model.Entities;



/**
 *
 * @author aldan
 */
public class MyOwnQueue implements ArrayQueue {
    
    private String[] data;
    private int queueSize;//number of elements in my queue
    private int capacity;
    private int front;//index of the front element
    private int back; //index of the back element
    
    public MyOwnQueue(int capacity){
        this.capacity=capacity;
        this.data=new String[capacity];
        this.queueSize=0;
        this.front=-1;
        this.back=-1;        
    }

    @Override
    public boolean Enqueue(String newElement) {
        
        if(queueSize >= capacity){
            return false;
        }       
        if (front==-1){
            front++;
        }        
        back++;
        data[back]=newElement;
        queueSize++;
        return true;
    }

    @Override
    public String Dequeue() {
        //checks if queue is empty (works for both approaches)
        if(queueSize==0){
            return null;            
        }
        
        //approach 1
        if(queueSize==1){
            String elementReturn = data[front];
            front--;
            back--;
            queueSize--;
            return elementReturn;
        }
        
        //Save the element in one variable (works for both approaches)
        String elementReturn = data[front];
        //approach 2
        //data[front] = null;
//        front++;
//        queueSize--;
//        return elementReturn;
        
        //approach 1
        for (int i = 0; i < queueSize; i++) {
            if (i+1 <= queueSize-1) {
                data[i] = data[i + 1];
            }
        }
        back--;
        queueSize--;
        return elementReturn;
    }

    @Override
    public String First() {
        if(queueSize == 0){
            return null;
        }
        return data[front];
        
    }

    @Override
    public String Last() {
        if(queueSize==0){
            return null;
        }        
        return data[back];
    }

    @Override
    public int size() {
        return queueSize;
    }

    @Override
    public boolean isEmpty() {
        if (queueSize == 0){
            return true;
        }
        return false;        
    }
    @Override
    public String toString(){
        String toReturn = "[ ";
        
        for(int i = front; i <= back; i++){
            toReturn += data[i] + ", ";
                       
        }
        toReturn += " ]";
        
        return toReturn;
    }
    
}
