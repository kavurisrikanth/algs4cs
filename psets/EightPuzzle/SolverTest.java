import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    private Board testBoard;
    private Solver testSolver;

    void setup(int[][] board) {
        testBoard = new Board(board);
        testSolver = new Solver(testBoard);
    }

    @Test
    void testSolutionBoard() {
        int[][] arr = {{1,2,3},{0,7,6},{5,4,8}};
        setup(arr);

        for (Board b: testSolver.solution())
            System.out.println(b);
    }

    @AfterEach
    void tearDown() {
        testBoard = null;
        testSolver = null;
    }
}