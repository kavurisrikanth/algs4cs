
import java.util.Iterator;
import java.util.NoSuchElementException;

/*****
 * Implementation of a deque.
 */

public class Deque<Item> implements Iterable<Item> {

    /*****
     * Node of a doubly-linked list.
     */
    private class Node {
        Item value;
        Node next;
        Node prev;

        Node(Item value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    /* Private class variables. */
    private Node head = null, tail = null;
    private int size = 0;

    /*****
     * Check if the deque is empty.
     * @return - true or false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*****
     * Get the size of the deque.
     * @return - Size, int.
     */
    public int size() {
        return size;
    }

    /*****
     * Add an item to the "first" of the deque.
     * @param item - The item.
     */
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Can't add a null element.");

        Node oldhead = head;
        head = new Node(item);
        head.next = oldhead;
        if (oldhead != null)
            oldhead.prev = head;
        if (tail == null)
            tail = head;
        size++;
    }

    /*****
     * Add an item to the "last" of the deque
     * @param item - The item.
     */
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Can't add a null element.");

        Node oldtail = tail;
        tail = new Node(item);
        tail.prev = oldtail;
        if (oldtail != null)
            oldtail.next = tail;
        if (head == null)
            head = tail;
        size++;
    }

    /*****
     * Remove and return the first element.
     * @return - The first element.
     */
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty.");

        Item ans = head.value;
        head = head.next;
        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        }
        return ans;
    }

    /*****
     * Remove and return the last element.
     * @return - The last element.
     */
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Deque is empty.");

        Item ans = tail.value;
        tail = tail.prev;
        size--;
        if (isEmpty()) {
            head = null;
            tail = null;
        }
        return ans;
    }

    /*****
     * Iterator class for deque.
     */
    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("The remove operation is not supported.");
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("Nothing left in deque.");

            Item ans = current.value;
            current = current.next;
            return ans;
        }
    }

    /*****
     * Get iterator for deque.
     * @return - Iterator for deque.
     */
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

}
