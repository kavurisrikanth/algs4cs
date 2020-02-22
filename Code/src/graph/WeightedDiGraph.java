package graph;

import edu.princeton.cs.algs4.Bag;

import java.util.Scanner;

public class WeightedDiGraph {
    private Bag<WeightedDiEdge>[] adj;
    private int v;
    private int e;

    public WeightedDiGraph(int v) {
        adj = (Bag<WeightedDiEdge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
        this.v = v;
        this.e = 0;
    }

    public WeightedDiGraph(Scanner sc) {
        if (sc == null) {
            throw new IllegalArgumentException("No scanner found");
        }

        v = sc.nextInt();
        adj = (Bag<WeightedDiEdge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }

        int e = sc.nextInt();
        if (e < 0) {
            throw new IllegalArgumentException("Number of edges cannot be negative");
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt(),
                to = sc.nextInt();
            assert isCorrectIndex(from) && isCorrectIndex(to);
            double weight = sc.nextDouble();
            addEdge(new WeightedDiEdge(from, to, weight));
        }
    }

    public void addEdge(WeightedDiEdge edge) {
        int from = edge.from(), to = edge.to();
        assert isCorrectIndex(from) && isCorrectIndex(to);
        adj[from].add(edge);
        this.e++;
    }

    public int V() {
        return v;
    }

    public int E() {
        return e;
    }

    private boolean isCorrectIndex(int x) {
        return x >= 0 && x < adj.length;
    }

    public Bag<WeightedDiEdge> adj(int cur) {
        assert isCorrectIndex(cur);
        return adj[cur];
    }
}
