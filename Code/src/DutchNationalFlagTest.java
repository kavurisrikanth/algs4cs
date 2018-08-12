import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DutchNationalFlagTest {
    private String[] arr;
    private final int NUM = 10;
    private final String red = "red", blue = "blue", white = "white";

    @BeforeEach
    void setup() {
        arr = new String[NUM];
    }

    @Test
    void testRandomArray() {
        int[] split = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            split[i] = StdRandom.uniform(3);
        }

        for (int i = 0; i < NUM; i++) {
            arr[i] = split[i] == 0 ? "white" : (split[i] == 1 ? "red" : "blue");
        }

        printArray(arr);
        DutchNationalFlag.sort(arr);
        printArray(arr);

        assertTrue(verify(arr));
    }

    @Test
    void testAllWhites() {
        for (int i = 0; i < NUM; i++) {
            arr[i] = "white";
        }

        printArray(arr);
        DutchNationalFlag.sort(arr);
        printArray(arr);
    }

    @Test
    void testRedsAndBlues() {
        int[] split = new int[NUM];
        for (int i = 0; i < NUM; i++) {
            split[i] = StdRandom.uniform(2) + 1;
        }

        for (int i = 0; i < NUM; i++) {
            arr[i] = (split[i] == 1 ? "red" : "blue");
        }

        printArray(arr);
        DutchNationalFlag.sort(arr);
        printArray(arr);
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

    private boolean verify(String[] arr) {
        int smallestRed = arr.length - 1,
                largestRed = 0,
                smallestWhite = arr.length - 1,
                largestWhite = 0,
                smallestBlue = arr.length - 1,
                largestBlue = 0;
        for (int i = 0; i < arr.length; i++) {
            String cur = arr[i];

            switch (cur) {
                case "red":
                    if (i < smallestRed)
                        smallestRed = i;
                    if (i > largestRed)
                        largestRed = i;
                    break;
                case "blue":
                    if (i < smallestBlue)
                        smallestBlue = i;
                    if (i > largestBlue)
                        largestBlue = i;
                    break;
                case "white":
                    if (i < smallestWhite)
                        smallestWhite = i;
                    if (i > largestWhite)
                        largestWhite = i;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid color found: " + cur);
            }
        }

        return smallestRed == 0 &&
                largestRed < smallestWhite &&
                largestWhite < smallestBlue &&
                largestBlue == arr.length - 1;
    }
}