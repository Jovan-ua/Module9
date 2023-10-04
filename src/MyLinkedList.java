public class MyLinkedList {
    private Node head;
    private Node tail;
    private int listSize;

    private static class Node {
        Object info;
        Node prev;
        Node next;

        public Node(Object data) {
            this.info = data;
            this.prev = prev;
            this.next = next;

        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        listSize = 0;
    }

    public void add(Object value) {
        Node node = new Node(value);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        listSize++;
    }

    private Node getNode(int index) {
        Node thisNode;
        if (index < listSize / 2) {
            thisNode = head;
            for (int i = 0; i < index; index++) {
                thisNode = thisNode.next;
            }
        } else {
            thisNode = tail;
            for (int i = listSize - 1; i > index; i--) {
                thisNode = thisNode.prev;
            }
        }
        return thisNode;
    }

    public Object get(int index) {
        if (index < 0 || index >= listSize){
            throw new IndexOutOfBoundsException("Index Out of Bounds, try another");
        }
        Node thisNode1 = getNode(index);
        return thisNode1.info;
    }


    public void remove(int index) {
        if (index < 0 || index >= listSize){
            throw new IndexOutOfBoundsException("Index Out of Bounds, try another");
        }
        Node thisNode = getNode(index);
        if (thisNode.prev != null) {
            thisNode.prev.next = thisNode.next;
        } else {
            head = thisNode.next;
        }
        if (thisNode.next != null) {
            thisNode.next.prev = thisNode.prev;
        } else {
            tail = thisNode.prev;
        }
        listSize--;
    }

    public int size() {
        return listSize;
    }

    public void clear() {
        head = null;
        tail = null;
        listSize = 0;
    }
}
