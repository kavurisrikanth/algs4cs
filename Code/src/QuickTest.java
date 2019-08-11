import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickTest {
    @Test
    void testQuickSort() {
        Integer[] arr = {0,9,8,7,6,5,4,3,2,1},
                  sorted = {0,1,2,3,4,5,6,7,8,9};
        Quick.sort(arr);
        printArray(arr);
        assertArrayEquals(sorted, arr);
    }

    void printArray(Comparable[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Comparable x: arr) {
            sb.append(x).append(" ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}