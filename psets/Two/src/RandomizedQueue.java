import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] arr;
    private int n, size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        n = 0;
        size = 0;
        arr = (Item[]) new Object[n + 1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        arr[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        Random rand = new Random();
        
    }

    // return a random item (but do not remove it)
    public Item sample() {}

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {}

    // unit testing (optional)
//    public static void main(String[] args)
}