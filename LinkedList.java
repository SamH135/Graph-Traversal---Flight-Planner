public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T data) {
        head = new Node<>(data, head);
    }
    
    private static class Node<T> {
        T data;
        Node<T> next;



        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}