import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Stack<Item> bag = null;

    public Bag() {
        bag = new Stack<>();
    }

    /*****
     * Add an item to the Bag
     * @param x - The item to be added.
     */
    public void add(Item x) {
        bag.push(x);
    }

    /*****
     * Get the size of the Bag, meaning the number of elements in it.
     * @return - Size of Bag.
     */
    public int size() {
        return bag.size();
    }

    /*****
     * Get an iterator for the Bag.
     * @return - Bag iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return bag.iterator();
    }
}
