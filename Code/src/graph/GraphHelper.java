package graph;

public class GraphHelper {


    public static void main(String[] args) {
        Graph graph = new Graph(10);
        assert !graph.areConnected(0, 1);
    }
}
