public class Stack<T> {
    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    // add values to stack
    public void push(T value) {
        list.addFirst(value);
    }

    // remove values from stack
    public T pop() {
        return list.removeFirst();
    }

    // check if stack contains any values
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
