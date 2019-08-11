import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testDimension() {
        int[][] testArr;

        testArr = new int[2][2];
        int iter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                testArr[i][j] = iter++;
            }
        }

        Board testBoard = new Board(testArr);
        assertEquals(2, testBoard.dimension());

        testArr = new int[3][3];
        iter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                testArr[i][j] = iter++;
            }
        }

        testBoard = new Board(testArr);
        assertEquals(3, testBoard.dimension());

        int[][] testArr2 = {{2,3,0}, {1,4,6}, {8,7,5}};
        testBoard = new Board(testArr2);
        assertEquals(3, testBoard.dimension());

        int[][] testArr3 = {{0,5,7}, {1,8,2}, {3,6,4}};
        testBoard = new Board(testArr3);
        assertEquals(3, testBoard.dimension());
    }

    @Test
    void testHamming() {
        int[][] testArr;

        testArr = new int[2][2];
        int iter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                testArr[i][j] = iter++;
            }
        }

        Board testBoard = new Board(testArr);
        assertEquals(3, testBoard.hamming());

        testArr = new int[3][3];
        iter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                testArr[i][j] = iter++;
            }
        }

        testBoard = new Board(testArr);
        assertEquals(8, testBoard.hamming());

        int[][] testArr2 = {{2,3,0}, {1,4,6}, {8,7,5}};
        testBoard = new Board(testArr2);
        assertEquals(7, testBoard.hamming());

        int[][] testArr3 = {{0,5,7}, {1,8,2}, {3,6,4}};
        testBoard = new Board(testArr3);
        assertEquals(8, testBoard.hamming());

        int[][] testArr4 = {{5,8,7}, {1,0,6}, {3,4,2}};
        testBoard = new Board(testArr4);
        assertEquals(7, testBoard.hamming());
    }

    @Test
    void testManhattan() {
        int[][] testArr;

        testArr = new int[2][2];
        int iter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                testArr[i][j] = iter++;
            }
        }

        Board testBoard = new Board(testArr);
        assertEquals(4, testBoard.manhattan());

        testArr = new int[3][3];
        iter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                testArr[i][j] = iter++;
            }
        }

        testBoard = new Board(testArr);
        assertEquals(12, testBoard.manhattan());

        int[][] testArr2 = {{2,3,0}, {1,4,6}, {8,7,5}};
        testBoard = new Board(testArr2);
        assertEquals(8, testBoard.manhattan());

        /* Test a small array and its neighbors */

        int[][] testArr3 = {{2,0},{1,3}},
                nArr1 = {{0,2},{1,3}},
                nArr2 = {{2,3},{1,0}};
        Board nBoard1 = new Board(nArr1),
                nBoard2 = new Board(nArr2);
        testBoard = new Board(testArr3);
        assertEquals(3, testBoard.manhattan());

        ArrayList<Board> neighbors = (ArrayList<Board>) testBoard.neighbors();
        for (Board b: neighbors) {
            if (b.equals(nBoard1)) {
                assertEquals(2, b.manhattan());
            } else {
                assertEquals(4, b.manhattan());
            }
        }
    }

    @Test
    void testNeighbors() {
        int[][] testArr = {{5,8,7}, {1,4,6}, {3,0,2}},
                neighborOne = {{5,8,7}, {1,0,6}, {3,4,2}},
                neighborTwo = {{5,8,7}, {1,4,6}, {3,2,0}},
                neighborThree = {{5,8,7}, {1,4,6}, {0,3,2}};
        Board testBoard = new Board(testArr);

        assertEquals(testBoard.hamming(), 7);
        assertEquals(testBoard.manhattan(), 17);

        ArrayList<Board> n = (ArrayList<Board>) testBoard.neighbors();
        assertEquals(n.size(), 3);
        for (Board b: n) {
            assertEquals(b.hamming(), 7);
            if (b.equals(new Board(neighborOne))) {
                assertEquals(b.manhattan(), 18);
            } else if (b.equals(new Board(neighborTwo))) {
                assertEquals(b.manhattan(), 16);
            } else {
                assertEquals(b.manhattan(), 16);
            }
        }
    }

//    @Test
//    void testNeighbors() {
//        int[][] testArr2 = {{2,3,0}, {1,4,6}, {8,7,5}};
//        Board testBoard = new Board(testArr2);
//
//        ArrayList<Board> neighbors = (ArrayList<Board>) testBoard.neighbors();
//        assertEquals(2, neighbors.size());
//
//        for (Board b: neighbors) {
//            System.out.println(b);
//        }
//
//        Board nb1 = neighbors.get(0),
//            nb2 = neighbors.get(1);
//        int[][] nArr2 = {{2,0,3}, {1,4,6}, {8,7,5}},
//                nArr1 = {{2,3,6}, {1,4,0}, {8,7,5}};
//
//        assertEquals(new Board(nArr1), nb1);
//        assertEquals(8, nb1.hamming());
//        assertEquals(9, nb1.manhattan());
//
//        assertEquals(new Board(nArr2), nb2);
//        assertEquals(6, nb2.hamming());
//        assertEquals(7, nb2.manhattan());
//    }

    /*
    @Test
    void testTwin() {
        int[][] newArr = {{8,0,3}, {1,4,6}, {7,5,2}};
        assertEquals(testBoard.twin(), new Board(newArr));
    }
    */
}