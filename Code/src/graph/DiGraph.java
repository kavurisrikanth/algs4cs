package graph;

import edu.princeton.cs.algs4.Bag;

public class DiGraph extends BaseGraph {
    public DiGraph(int n) {
        super(n);
    }

    public void connect(int one, int other) {
        assert isCorrectIndex(one) && isCorrectIndex(other);
        adj[one].add(other);
    }
}
