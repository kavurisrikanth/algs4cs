package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTest {
    @Test
    void testMergeSort() {
        Integer[] arr = {9,8,7,6,5},
                  sorted = {5,6,7,8,9};
        Merge.sort(arr);
        assertArrayEquals(sorted, arr);
    }
}