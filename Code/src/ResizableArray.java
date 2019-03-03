import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizableArray <Item> {
    private int n, filled;
    private Item[] arr;

    /**
     * Constructor
     */
    public ResizableArray() {
        this(5);
    }

    public ResizableArray(int n) {
        this.n = n;
        filled = 0;
        arr = (Item[]) new Object[n];
    }

    /**
     * Copy constructor
     * @param other - The other ResizableArray.
     */
    public ResizableArray(ResizableArray other) {
        n = other.n;
        filled = other.filled;
        arr = (Item[]) new Object[n];
        for (int i = 0; i < filled; i++)
            arr[i] = (Item) other.arr[i];
    }

    /**
     * Insert an item into the array at an index.
     * @param index - The index.
     * @param item - The item.
     */
    public void insertAt(int index, Item item) {
        // Basic index range validation.
        if (invalidIndex(index))
            throw new IndexOutOfBoundsException("Invalid index: " + index);

        if (filled >= n/2)
            resize(false);

        // If the index is some place where there's already data, then move the data
        if (index < filled) {
            System.arraycopy(arr, index, arr, index + 1, filled - index);
        }

        // Insert.
        arr[index] = item;
        filled++;
    }

    /**
     * Remove an item from an index in the array.
     * @param index - The index.
     * @return - The removed item.
     */
    public Item removeFrom(int index) {
        // Basic index range validation.
        if (invalidIndex(index))
            throw new IndexOutOfBoundsException("Invalid index: " + index);

        // Get the item
        Item ans = arr[index];

        // Copy items one index over, if necessary
        if (index < filled && filled - 1 - index >= 0) {
            System.arraycopy(arr, index + 1, arr, index, filled - 1 - index);
        }

        // Resize if necessary
        --filled;
        if (filled > 0 && filled <= n/4)
            resize(true);

        // Done
        return ans;
    }

    /**
     * View an item at an index in the array.
     * @param index - The index.
     * @return - The item.
     */
    public Item viewItemAt(int index) {
        // Basic index range validation.
        if (invalidIndex(index))
            throw new IndexOutOfBoundsException("Invalid index: " + index);

        return arr[index];
    }

    /**
     * Peek at the topmost item, like in a stack.
     * @return - The topmost item.
     */
    public Item peek() {
        return viewItemAt(filled - 1);
    }

    /**
     * Push an item on to the array like a stack.
     * @param item - The item.
     */
    public void push(Item item) {
        insertAt(filled, item);
    }

    /**
     * Pop an item off the array like a stack.
     * @return - The item.
     */
    public Item pop() {
        return removeFrom(filled - 1);
    }

    /**
     * Get the length of the Resizable array.
     * @return - Length, meaning the number of items.
     */
    public int length() {
        return filled;
    }

    /**
     * Get the size, or capacity, of the Resizable array.
     * @return - The size.
     */
    public int size() {
        return n;
    }

    /**
     * Check if the array is empty.
     * @return - true or false.
     */
    public boolean isEmpty() {
        return filled == 0;
    }

    /**
     * Exchange two items.
     * @param one - First index
     * @param two - Second index
     */
    public void exch(int one, int two) {
        if (invalidIndex(one))
            throw new IndexOutOfBoundsException("Invalid index: " + one);

        if (invalidIndex(two))
            throw new IndexOutOfBoundsException("Invalid index: " + two);

        Item temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    /**
     * Check if the index is invalid.
     * @param index - The index.
     * @return - true or false.
     */
    private boolean invalidIndex(int index) {
        return index > filled || index < 0 || index > n;
    }

    /**
     * Resize the array.
     * @param shrink - Do we shrink or expand?
     */
    private void resize(boolean shrink) {
        /*
         * If shrink, then cut the array length in half.
         * Otherwise, double the array length.
         *
         * Once that's done, copy everything from 0 till n.
         */

        int prevLen = n, newLen = shrink ? Math.max(prevLen/2, filled + 1) : prevLen * 2;
        Item[] newArr = (Item[]) new Object[newLen];
        if (filled >= 0) System.arraycopy(arr, 0, newArr, 0, filled);
        arr = newArr;
        n = newLen;
    }

    /**
     * Class to create an iterator for the Resizable array.
     */
    private class ResizableArrayIterator implements Iterator<Item> {
        private int current = filled;

        @Override
        public boolean hasNext() {
            return current == 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more elements.");

            return arr[--current];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported.");
        }
    }

    public Iterator<Item> iterator() {
        return new ResizableArray.ResizableArrayIterator();
    }

    /**
     * The toString method.
     * @return - String representation of a Resizable array.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < filled; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
