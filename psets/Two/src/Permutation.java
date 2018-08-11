import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Deque<String> collection = new Deque<>();

        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            collection.addLast(str);
        }

        for (int i = 0; i < k; i++) {
            boolean way = StdRandom.bernoulli();
            StdOut.println(way ? collection.removeFirst() : collection.removeLast());
        }
    }
}
