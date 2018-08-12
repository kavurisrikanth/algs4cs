import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    // Class members.
    private Item[] arr;
    private int n, size, numNulls;

    /*****
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        n = 0;
        size = 0;
        numNulls = 0;
        arr = (Item[]) new Object[n + 1];
    }

    /*****
     * is the randomized queue empty?
     * @return - true or false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*****
     * return the number of items on the randomized queue
     * @return - Size of queue.
     */
    public int size() {
        return size;
    }

    /*****
     * add the item
     * @param item - Item to be added.
     */
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Can't insert null.");

        if (size == arr.length)
            resize(false);

        arr[n++] = item;
        size++;
    }

    /*****
     * remove and return a random item
     * @return - Item to be deleted.
     */
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty.");

        int index = 0;
        Item ans;
        do {
            index = StdRandom.uniform(n);
            ans = arr[index];
        } while (ans == null);

        arr[index] = null;
        numNulls++;
        size--;

        if (numNulls >= size)
            resize(true);

        return ans;
    }

    /*****
     * Resize the array.
     * @param shrink - Size up or down?
     */
    private void resize(boolean shrink) {
        int newSize = shrink ? n/2 : n*2;
        if (newSize == 0) {
            n = 0;
            return;
        }

        Item[] newArr = (Item[]) new Object[newSize];
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != null)
                newArr[i++] = arr[j];
        }
        arr = newArr;
        n = i;
        numNulls = 0;
    }

    /*****
     * return a random item (but do not remove it)
     * @return - Item to be returned.
     */
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty.");

        int remIndex = StdRandom.uniform(n);
        return arr[remIndex];
    }

    /*****
     * Iterator class for this queue.
     */
    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] shuffledArray;
        private int current = 0;

        /*****
         * Constructor.
         */
        public RandomizedQueueIterator() {
            shuffledArray = (Item[]) new Object[arr.length];
            StdRandom.shuffle(shuffledArray);
        }

        /*****
         * Check if there are more elements.
         * @return - true or false.
         */
        @Override
        public boolean hasNext() {
            return current != n;
        }

        /*****
         * Get the next item.
         * @return - Next item.
         */
        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more elements.");

            return shuffledArray[current++];
        }

        /*****
         * remove an element. Not supported.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported.");
        }
    }

    /*****
     * return an independent iterator over items in random order
     * @return - Iterator.
     */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // unit testing (optional)
//    public static void main(String[] args)
}