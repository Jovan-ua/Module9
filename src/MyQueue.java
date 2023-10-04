public class MyQueue {
    private Object[] arr;
    private int head;
    private int tail;
    private int arrSize;
    private int capacity;
    public MyQueue(int capacity){
        this.capacity = capacity;
        arr = new Object[capacity];
        head = 0;
        tail = -1;
        arrSize = 0;
    }
    public void add(Object info){
        tail = (tail + 1) % capacity;
        arr[tail] = info;
        arrSize++;
    }
    public void clear(){
        for (int i = 0; i < capacity; i++){
            arr[i] = null;
        }
        head = 0;
        tail = -1;
        arrSize = 0;
    }
    public int size(){
        return arrSize;
    }
    public Object peek(){
        return arr[head];
    }
    public Object poll(){
        Object deletedArrElement = arr[head];
        arr[head] = null;
        head = (head + 1) % capacity;
        return deletedArrElement;
    }
}
