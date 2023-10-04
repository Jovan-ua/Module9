public class MyHashMap {
    private static final int default_capacity = 16;
    private Node[] arr;
    private int size;

    public MyHashMap() {
        arr = new Node[default_capacity];
        size = 0;
    }

    private static class Node {
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;

        }
    }

    private int hash(Object key) {
        return key.hashCode() & (arr.length - 1);
    }

    public void put(Object key, Object value) {
        int index = hash(key);
        Node node = new Node(key, value);
        if (arr[index] == null) {
            arr[index] = node;
        } else {
            Node thisNode = arr[index];
            while (thisNode.next != null) {
                if (thisNode.key.equals(key)) {
                    thisNode.value = value;
                    return;
                }
                thisNode = thisNode.next;
            }
            if (thisNode.key.equals(key)) {
                thisNode.value = value;
            } else {
                thisNode.next = node;
            }
        }

        size++;
    }

    public void remove(Object key) {
        int index = hash(key);
        Node thisNode = arr[index];
        Node prev = null;
        while (thisNode != null) {
            if (thisNode.key.equals(key)) {
                if (prev == null) {
                    arr[index] = thisNode.next;
                } else {
                    prev.next = thisNode.next;
                }
                size--;
                return;

            }
            prev = thisNode;
            thisNode = thisNode.next;
        }
    }
    public void clear(){
        arr = new Node[default_capacity];
        size = 0;
    }
    public int size(){
        return size;
    }
    public Object get(Object key){
        int index = hash(key);
        Node thisNode = arr[index];
        while (thisNode != null){
            if (thisNode.key.equals(key)){
                return thisNode.value;
            }
            thisNode = thisNode.next;
        }
    return null;
    }
}
