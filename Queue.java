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
        if(tail == capacity - 1){
            a[0] = elem;
            tail = 0;
            elem_num++;
        }
        else{
            a[tail+1] = elem;
            tail++;
            elem_num++;
        }  
    }
    
    public int dequeue() {
        if (isEmpty()){}
        // Exception("Queue is empty, dequeue was denied");
        //TODO
        return 0;
    }
    
    private void resize(int newSize){
        int [] newArray = new int[newSize];
        if (tail >= head){
            int j = 0;
            for (int i = head; i <= tail; i++){
               newArray[j] = a[i];
               j++;   
            }
        }
        else{
            int j=0;
            for (int i = head; i < capacity;i++){
                newArray[j] = a[i];
                j++;
            }
            for (int i = 0; i <= tail; i++){
                newArray[j] = a[i];
                j++;
            }
            
        }
        a = newArray;
        head = 0;
        tail = elem_num - 1;
    }
    
    public int size(){
        return elem_num;
    }
}
