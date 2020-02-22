package heap;

import helpers.ResizableArray;

public class MaxHeap<Key extends Comparable<Key>> {
    private ResizableArray<Key> pq;

    /**
     * Constructor
     */
    public MaxHeap() {
        pq = new ResizableArray<>();
    }

    /**
     * Check if heap is empty
     * @return - true or false
     */
    public boolean isEmpty() {
        return pq.isEmpty();
    }

    /**
     * Insert key into heap.
     * @param key - The key.
     */
    public void insert(Key key) {
        pq.push(key);
        swim(pq.length() - 1);
    }

    /**
     * Remove the Maximum key from the heap.
     * @return - The Maximum key.
     */
    public Key delMax() {
        pq.exch(0, pq.length() - 1);
        Key ans = pq.pop();
        sink(0);

        return ans;
    }

    /**
     * Swim a key to its proper position
     * @param k - The key index.
     */
    private void swim(int k) {
        /*
        while (k > 0 && gt(k, parent(k))) {
            pq.exch(k, parent(k));
            k = k/2;
        }
        */

        if (k <= 0)
            return;

        int p = parent(k);

        if (p <= 0)
            return;

        if (gt(p, k))
            return;

        pq.exch(p, k);
        swim(p);
    }

    /**
     * Sink a key to its proper position
     * @param k - The key index.
     */
    private void sink(int k) {
        if (k >= pq.length())
            return;

        int i = leftChild(k), j = rightChild(k);

        if (i >= pq.length() || j >= pq.length())
            return;

        if (gt(k, i) && gt(k, j))
            return;

        int n = (gt(i, j) ? i : j);
        pq.exch(k, n);
        sink(n);
    }

    /**
     * Get the left child of a key.
     * @param k - The key index.
     * @return - The left child index.
     */
    private int leftChild(int k) {
        if (k < 0 || k >= pq.length()) throw new IllegalArgumentException("Invalid index: " + k);

        return 2 * k + 1;
    }

    /**
     * Get the right child of a key.
     * @param k - The key index.
     * @return - The right child index.
     */
    private int rightChild(int k) {
        if (k < 0 || k >= pq.length()) throw new IllegalArgumentException("Invalid index: " + k);

        return 2 * (k + 1);
    }

    /**
     * Get the parent of a key.
     * @param k - The key index.
     * @return - The parent index.
     */
    private int parent(int k) {
        if (k < 0 || k >= pq.length()) throw new IllegalArgumentException("Invalid index: " + k);

        return (k - 1)/2;
    }

    /**
     * Check if one key is less than another.
     * @param i - First key index
     * @param j - Other key index
     * @return - Comparison result
     */
    private boolean gt(int i, int j) {
        return pq.viewItemAt(i).compareTo(pq.viewItemAt(j)) > 0;
    }

    @Override
    public String toString() {
        return pq.toString();
    }
}
