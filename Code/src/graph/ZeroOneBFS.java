package graph;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Deque;
import java.util.PriorityQueue;

public class ZeroOneBFS {
    private WeightedDiGraph graph;
    private double[] distTo;
    private WeightedDiEdge[] edgeTo;

    public ZeroOneBFS(WeightedDiGraph graph) {
        this.graph = graph;
        this.distTo = new double[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0;
        this.edgeTo = new WeightedDiEdge[graph.V()];
        findPaths();
    }

    private void findPaths() {
        IndexMinPQ<Integer> nextNodes = new IndexMinPQ<>(graph.V());
        nextNodes.insert(0, 0);
        while (!nextNodes.isEmpty()) {
            int cur = nextNodes.delMin();
            for (WeightedDiEdge edge : graph.adj(cur)) {
                int next = edge.to();
                if (distTo[next] > distTo[cur] + edge.weight()) {
                    distTo[next] = distTo[cur] + edge.weight();
                    edgeTo[next] = edge;
                    int newWeight = (int) distTo[next];
                    if (nextNodes.contains(next)) nextNodes.decreaseKey(next, newWeight);
                    else nextNodes.insert(next, newWeight);
                }
            }
        }
    }

    public int getMinDistance(int x) {
        return (int) distTo[x];
    }

    private boolean isValidIndex(int x) {
        return x >= 0 && x < graph.V();
    }
}
