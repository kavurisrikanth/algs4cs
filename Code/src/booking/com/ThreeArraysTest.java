package booking.com;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ThreeArraysTest {

    @Test
    void testOne() {
        int[][] arrays = {
            {2,3,1,4,5,2,1,6,7},
            {1,3,1,7,3,8,9,0},
            {0,9,8}
        };
        Integer[] ans = {0, 1, 3, 7, 8, 9};

        Integer[] result = ThreeArrays.go(arrays);
        Arrays.sort(result);

        assertArrayEquals(result, ans);
    }

    @Test
    void testTwo() {
        int[][] arrays = {
            {2,3,1,4,5,2,1,6,7},
            {8,9,0},
            {11,12,10}
        };
        Integer[] ans = {};

        assertArrayEquals(ThreeArrays.go(arrays), ans);
    }
}