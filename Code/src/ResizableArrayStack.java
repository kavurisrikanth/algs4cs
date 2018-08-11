import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizableArrayStack<Item> implements Iterable<Item> {

    private int n = 0;
    private Item[] arr = null;

    public ResizableArrayStack() {
        arr = (Item[]) new Object[n + 1];
    }

    public void push(Item item) {
        if (n == arr.length)
            resize(false);

        arr[n++] = item;
    }

    private void resize(boolean shrink) {
        /*
         * If shrink, then cut the array length in half.
         * Otherwise, double the array length.
         *
         * Once that's done, copy everything from 0 till n.
         */

        int prevLen = arr.length;
        Item[] newArr = (Item[]) new Object[shrink ? prevLen/2 : prevLen * 2];
        if (n >= 0) System.arraycopy(arr, 0, newArr, 0, n);
        arr = newArr;
    }

    public Item pop() {
        Item ans = arr[--n];
        arr[n] = null;

        if (n > 0 && n == arr.length/4)
            resize(true);

        return ans;
    }

    public Item peek() {
        return arr[n - 1];
    }

    public boolean empty() {
        return n == 0;
    }

    private class ResizableArrayStackIterator implements Iterator<Item> {
        private int current = n;

        @Override
        public boolean hasNext() {
            return current == 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("Stack is empty.");

            return arr[--current];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported.");
        }
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new ResizableArrayStackIterator();
    }
}
