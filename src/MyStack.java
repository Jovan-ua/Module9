public class MyStack {
    private Object[] arr;
    private int head;
    private int arrSize;
    private int capacity;
    public MyStack(int capacity){
        this.capacity = capacity;
        arr = new Object[capacity];
        head = -1;
        arrSize = 0;
    }
    public void push(Object info){
        head++;
        arr[head] = info;
        arrSize++;
    }
    public void remove(int index){
        for (int i = index; i < head; i++ ){
            arr[i] = arr[i + 1];
        }
        arr[head] = null;
        head--;
        arrSize--;
    }
    public void clear(){
        for (int i = 0; i <= head; i++){
            arr[i] = null;
        }
        head = -1;
        arrSize = 0;
    }
    public int size(){
        return arrSize;
    }
    public Object peek(){
        return arr[head];
    }
    public Object pop(){
        Object deletedArrElement = arr[head];
        arr[head] = null;
        head--;
        arrSize--;
        return deletedArrElement;
    }
}
