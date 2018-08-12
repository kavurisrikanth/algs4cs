import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private Node first = null;
    private int size = 0;

    private class Node {
        Item value;
        Node next;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.value = item;
        first.next = oldfirst;
        size++;
    }

    public Item pop() {
        Node top = first;
        first = first.next;
        return top.value;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return first == null;
    }

    public Item peek() {
        return first.value;
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("Stack is empty.");

            Item ans = current.value;
            current = current.next;
            return ans;
        }

        public void remove() {
            throw new UnsupportedOperationException("This method is not supported.");
        }
    }

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

}
