import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizableArrayStack<Item> implements Iterable<Item> {

    private ResizableArray<Item> arr;

    public ResizableArrayStack() {
        arr = new ResizableArray<>();
    }

    public void push(Item item) {
        arr.push(item);
    }

    public Item pop() {
        return arr.pop();
    }

    public Item peek() {
        return arr.peek();
    }

    public boolean empty() {
        return arr.isEmpty();
    }

    @Override
    public Iterator<Item> iterator() {
        return arr.iterator();
    }
}
