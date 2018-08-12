import edu.princeton.cs.algs4.StdRandom;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DequeTest {
    private Deque<Integer> deque;

    @BeforeEach
    public void createDeque() {
        deque = new Deque<>();
    }

    @AfterAll
    public void destroyDeque() {
        deque = null;
    }

    @Test
    public void checkEmptyAndSizeOnEmptyDeque() {
        assertTrue(deque.isEmpty());
        assertEquals(deque.size(), 0);
    }

    @Test
    public void insertAndCheckEmpty() {
        deque.addFirst(10);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void insertAndCheckSize() {
        deque.addFirst(10);
        assertEquals(deque.size(), 1);
    }

    @Test
    public void insertAndRemoveFromFront() {
        int num = 1000000;
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = StdRandom.uniform(5000);
            deque.addFirst(arr[i]);
        }

        for (int i = num - 1; i >= 0; i--) {
            assertEquals((int)deque.removeFirst(), arr[i]);
        }
    }

    @Test
    public void insertAndRemoveFromBack() {
        int num = 1000000;
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = StdRandom.uniform(5000);
            deque.addLast(arr[i]);
        }

        for (int i = num - 1; i >= 0; i--) {
            assertEquals((int)deque.removeLast(), arr[i]);
        }
    }

    @Test
    public void insertFrontAndRemoveBack() {
        int num = 1000000;
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = StdRandom.uniform(5000);
            deque.addFirst(arr[i]);
        }

        for (int i = 0; i < num; i++) {
            assertEquals((int)deque.removeLast(), arr[i]);
        }

        assertTrue(deque.isEmpty());
    }

    @Test
    public void insertBackAndRemoveFront() {
        int num = 1000000;
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = StdRandom.uniform(5000);
            deque.addLast(arr[i]);
        }

        for (int i = 0; i < num; i++) {
            assertEquals((int)deque.removeFirst(), arr[i]);
        }
    }

    @Test
    public void checkSizeAfterInsertAndRemove() {
        int num = 1000000;
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = StdRandom.uniform(5000);
            deque.addLast(arr[i]);
        }

        for (int i = 0; i < num/2; i++) {
            deque.removeFirst();
        }

        assertEquals(deque.size(), num/2);
    }

    @Test
    public void submissionCheck()  {
        assertEquals(deque.size(), 0);
        assertTrue(deque.isEmpty());

        deque.addFirst(2);

        assertEquals( (int)deque.removeLast(), 2);
        assertTrue( deque.isEmpty() );
        deque.addLast(5) ;
        deque.addLast(6) ;
        assertEquals((int) deque.removeFirst(), 5);
    }

    @Test
    public void testIterator() {
        int num = 1000000;
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = StdRandom.uniform(5000);
            deque.addLast(arr[i]);
        }

        int i = 0;
        Iterator<Integer> dequeIterator = deque.iterator();
        while (dequeIterator.hasNext()) {
            assertEquals((int)dequeIterator.next(), arr[i++]);
        }
    }

    @Test
    public void insertAndRemoveAndCheckSize() {
        deque.addFirst(1);
        assertEquals(deque.size(), 1);
        assertFalse(deque.isEmpty());
        assertEquals((int)deque.removeLast(), 1);
        assertTrue(deque.isEmpty());

        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);

        assertFalse(deque.isEmpty());
        assertEquals((int)deque.removeFirst(), 3);
        assertFalse(deque.isEmpty());
        assertEquals((int)deque.size(), 2);

        Iterator<Integer> dequeIterator = deque.iterator();
        int i = 0;
        while (dequeIterator.hasNext()) {
            i++;
            dequeIterator.next();
        }
        assertEquals(i, 2);
    }
}