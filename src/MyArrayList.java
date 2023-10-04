public class MyArrayList {
    private Object[] arr;
    private int arrSize;

    public MyArrayList() {
        arr = new Object[10];
        arrSize = 0;
    }

    public void add(Object value) {
        if (arrSize == arr.length) {
            int bigSize = arr.length * 2;
            Object[] newArr = new Object[bigSize];
            System.arraycopy(arr, 0, newArr, 0, arrSize);
            arr = newArr;
        }
        arr[arrSize] = value;
        arrSize++;
    }

    public void remove(int index) {
        for (int i = index; i < arrSize - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arrSize--;
    }

    public void clear() {
        arr = new Object[10];
        arrSize = 0;
    }

    public int size() {
        return arrSize;

    }

    public Object get(int index) {
        return arr[index];
    }
}
