import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest {
    private RandomizedQueue<Integer> queue;
    private final int LARGE_NUM = 10;

    @BeforeEach
    public void initialize() {
        queue = new RandomizedQueue<>();
    }

    @AfterEach
    public void destroy() {
        queue = null;
    }

    @Test
    public void enqueueAndDequeueAFewNumbers() {
        queue.enqueue(123);
        queue.enqueue(456);
        int x = queue.dequeue();
        assertTrue(x == 123 || x == 456);
        queue.enqueue(321);
        assertEquals(queue.size(), 2);
    }

    @Test
    public void enqueueAndDequeueManyNumbers() {
        int num = LARGE_NUM, limit = 5000;
        for (int i = 0; i < num; i++) {
            queue.enqueue(StdRandom.uniform(limit));
        }
        assertFalse(queue.isEmpty());

        for (int i = 0; i < num; i++) {
            queue.dequeue();
        }
        assertTrue(queue.isEmpty());

        queue.enqueue(0);
        assertFalse(queue.isEmpty());
        assertEquals((int)queue.sample(), 0);
    }
}