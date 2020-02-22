package graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortestPathTest {
    private WeightedDiGraph graph;

    @BeforeEach
    public void setup() throws FileNotFoundException {
        File file = new File("E:\\projects\\Algorithms\\testing\\tinyGraph.txt");
        Scanner sc = new Scanner(file);
        graph = new WeightedDiGraph(sc);
        sc.close();
    }

    @Test
    public void distanceTest() {
        Dijkstra sp = new Dijkstra(graph, 0);
        Assertions.assertEquals(1.0, sp.distTo(2));
        Assertions.assertEquals(1.5, sp.distTo(3));
        Assertions.assertEquals(2.5, sp.distTo(1));
        Assertions.assertEquals(Double.POSITIVE_INFINITY, sp.distTo(7));
    }

    @Test
    public void zeroOneTest() {
        int[] arr = {1, 2, 1, 3, 4, 3, 5, 3, 6, 3};
        int k = 2;
        int cost = 28;
        graph = new WeightedDiGraph(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int x = 1;
            while (x <= k && i + x < arr.length) {
                double weight = arr[i + x] == arr[i] ? 0.0 : 1.0;
                graph.addEdge(new WeightedDiEdge(i, i + x, weight));
                x++;
            }
        }

        ZeroOneBFS sp = new ZeroOneBFS(graph);
        int minDist = sp.getMinDistance(arr.length - 1);
        Assertions.assertEquals(28, minDist * cost);
    }
}
