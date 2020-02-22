package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseGraph {
    List<Integer>[] adj;

    int v;
    int e;

    public BaseGraph(int n) {
        adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        this.v = n;
        this.e = 0;
    }

    abstract public void connect(int one, int other);

    public boolean isCorrectIndex(int index) {
        return index >= 0 && index < adj.length;
    }
}
