package graph;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class Dijkstra {
    private WeightedDiGraph graph;
    private int s;
    private double[] distTo;
    private WeightedDiEdge[] pathTo;

    public Dijkstra(WeightedDiGraph graph, int start) {
        this.graph = graph;
        this.s = start;
        distTo = new double[graph.V()];
        pathTo = new WeightedDiEdge[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;
        pathTo[s] = null;

        findPaths();
    }

    private void findPaths() {
        IndexMinPQ<Double> heap = new IndexMinPQ<>(graph.V());
        heap.insert(s, distTo[s]);
        while (!heap.isEmpty()) {
            int from = heap.delMin();
            for (WeightedDiEdge edge : graph.adj(from)) {
                int to = edge.to();
                if (distTo[to] > distTo[from] + edge.weight()) {
                    distTo[to] = distTo[from] + edge.weight();
                    pathTo[to] = edge;
                    if (heap.contains(to)) heap.decreaseKey(to, distTo[to]);
                    else heap.insert(to, distTo[to]);
                }
            }
        }
    }

    public double distTo(int w) {
        assert isValidIndex(w);
        return distTo[w];
    }

    public Iterable<WeightedDiEdge> pathTo(int w) {
        Stack<WeightedDiEdge> path = new Stack<>();
        if (distTo[w] == Double.POSITIVE_INFINITY) {
            return path;
        }
        while (pathTo[w] != null) {
            path.push(pathTo[w]);
            w = pathTo[w].from();
        }
        return path;
    }

    private boolean isValidIndex(int x) {
        return x >= 0 && x < graph.V();
    }
}
