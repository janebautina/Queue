import edu.princeton.cs.algs4.*;
import java.lang.*;

    
public class Queue {
    
    private int capacity;   
    private int [] q;    
    private int elemNum; //number of elements in the queue   
    private int head; // pointer to the first element in the queue
    private int tail; //pointer to the last element in the queue
    
    public Queue(int size) {
        capacity = size;
        q = new int[capacity];
    }
    
    public boolean isEmpty() { 
       return elemNum == 0; 
    }
    
    public void enqueue(int elem) { //add an element to the queue
        if (elemNum == capacity) {
           resize();
        }
        if (tail == capacity ) {
            tail = 0;
            q[tail++] = elem;
            elemNum++;
        }
        else {
            q[tail] = elem;
            tail++;
            elemNum++;
        }  
    }
    
    public int dequeue() { //delete an element from the queue
        if (isEmpty())
            return 0;
        elemNum--;
        return q[head++];
    }
    
    private void resize() { // double array size
        int oldCapacity = capacity;
        capacity *= 2;
        int [] newArray = new int[capacity];
        if (tail > head) {
            int j = 0;
            for (int i = head; i <= tail - 1; i++) {
               newArray[j] = q[i];
               j++;   
            }
        }
        else {
            int j = 0;
            for (int i = head; i < oldCapacity; i++) {
                newArray[j] = q[i];
                j++;
            }
            for (int i = 0; i < tail; i++) {
                newArray[j] = q[i];
                j++;
            }
            
        }
        q = newArray;
        head = 0;
        tail = elemNum;
    }
    
    public int size() { // size of the queue
        return elemNum;
    }
    
    public String toString() {
        String st = "";
        for (int i = 0; i < capacity; i++) {
           st = st + new Integer(q[i]).toString() + " -> ";
        }
        return st;    
    }    
}
