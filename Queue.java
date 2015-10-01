public class Queue{
    
    private int capacity;
    
    private int [] a;
    
    private int elem_num;
    
    private int head;
    
    private int tail;
    
    public Queue(int size){
        capacity = size;
        head = 0;
        tail = 0;
        a = new int[capacity];
    }
    
    public boolean isEmpty() {
       return elem_num == 0; 
    }
    
    public void enqueue(int elem) {
        if(elem_num == capacity){
           capacity = capacity * 2;
           resize(capacity);
        }
        if(head == tail){
            if(elem_num <= capacity){
                a[tail+1] = elem;
                tail++;
                elem_num++;
            }
        }
        else if (head < tail){
            if(tail < capacity){
                a[tail+1] = elem;
                tail++;
                elem_num++;
            }
            else{
                a[0] = elem;
                tail = 0;
                elem_num++;
            }  
        }
        else{
            a[tail+1] = elem;
            tail++;
            elem_num++;
        }
     
    }
    
    public int dequeue() {
        return 0;
    }
    
    private void resize(int newSize){
        int [] newArray = new int[newSize];
        for (int i = 0; i <= newSize; i++){
            newArray[i] = a[i];
        }
        a = newArray;
    }
    
    public int size(){
        return elem_num;
    }
}