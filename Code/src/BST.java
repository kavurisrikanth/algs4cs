import java.util.ArrayList;
import java.util.List;

class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private T data;
    private Node<T> left, right;

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(T data) {
        this(data, null, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public boolean equals(Node<T> o) {
        return this.compareTo(o) == 0;
    }


    @Override
    public int compareTo(Node<T> o) {
        return data.compareTo(o.getData());
    }
}

public class BST<T extends Comparable<T>> {
    private Node<T> root;
    
    public BST() {
        
    }
    
    public void insert(T item) {
        root = insert(item, root);
    }
    
    private Node<T> insert(T item, Node<T> cur) {
        // If it's a leaf, create a new Node
        if (cur == null) {
            return new Node<>(item);
        }
        
        int compare = item.compareTo(cur.getData());
        if (compare < 0) {
            cur.setLeft(insert(item, cur.getLeft()));
        } else if (compare > 0) {
            cur.setRight(insert(item, cur.getRight()));
        }

        return cur;
    }

    public Node<T> find(T item) {
        return find(item, root);
    }

    private Node<T> find(T item, Node<T> cur) {
        if (cur == null)
            return null;

        int compare = item.compareTo(cur.getData());
        if (compare == 0) return cur;
        if (compare < 0) return find(item, cur.getLeft());
        return find(item, cur.getRight());
    }

    public boolean exists(T item) {
        return find(item) != null;
    }

    public List<T> getPreOrder() {
        List<T> preOrder = new ArrayList<>();
        getPreOrder(root, preOrder);
        return preOrder;
    }

    private void getPreOrder(Node<T> cur, List<T> order) {
        if (cur == null)
            return;

        getPreOrder(cur.getLeft(), order);
        order.add(cur.getData());
        getPreOrder(cur.getRight(), order);
    }


}
