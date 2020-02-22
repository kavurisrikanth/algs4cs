package sorting;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionTest {
    private final int SIZE = 1000;
    private Integer[] arr;

    @BeforeEach
    void setup() {
        arr = new Integer[SIZE];
    }

    @Test
    void sortRandomNumbers() {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = StdRandom.uniform(5000);
        }

        Insertion.sort(arr);

        assertTrue(verifySorted(arr));
    }

    private void printArray(Comparable[] arr) {
        StringBuilder s = new StringBuilder();
        s.append("[ ");
        for (Comparable anArr : arr) {
            s.append(anArr).append(" ");
        }
        s.append("]");
        System.out.println(s.toString());
    }

    private boolean verifySorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        }

        return true;
    }
}