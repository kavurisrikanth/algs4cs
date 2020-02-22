package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphTest {
    private Graph graph;

    @BeforeEach
    public void init() {
        graph = new Graph(10);
    }

    @Test
    public void emptyGraphNothingConnected() {
        Assertions.assertEquals(10, graph.v());
        Assertions.assertEquals(0, graph.e());
        for (int i = 0; i < graph.v(); i++) {
            for (int j = 0; j < graph.v(); j++) {
                if (i != j) {
                    Assertions.assertFalse(graph.areConnected(i, j));
                    graph.resetDfs();
                }
            }
        }
    }

    @Test
    public void someConnections() {
        graph.connect(0, 1);
        graph.connect(2, 3);
        graph.connect(4, 5);
        graph.connect(6, 7);
        graph.connect(8, 9);
        graph.connect(9, 0);

        List<Integer> allowed = new ArrayList<>();
        allowed.add(0);
        allowed.add(1);
        allowed.add(8);
        allowed.add(9);

        for (int i = 0; i < graph.v(); i++) {
            for (int j = 0; j < graph.v(); j++) {
                if (i != j) {
                    if (allowed.contains(i) && allowed.contains(j)) {
                        Assertions.assertTrue(graph.areConnected(i, j));
                    } else {
                        Assertions.assertFalse(graph.areConnected(i, j));
                    }
                }
                graph.resetDfs();
            }
        }
    }
}
