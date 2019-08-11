import java.util.ArrayList;

public class Board {
    private int[][] blocks;
    private int hamming;
    private int manhattan;
    final private int length;
    private int zeroRow, zeroCol;

    public Board(int[][] blocks) {
        // construct a board from an n-by-n array of blocks
        // (where blocks[i][j] = block in row i, column j)
        length = blocks.length;
        this.blocks = new int[length][length];
        hamming = 0;
        manhattan = 0;

        for (int rowNum = 0; rowNum < length; rowNum++) {
            for (int colNum = 0; colNum < length; colNum++) {
                int cur = blocks[rowNum][colNum],
                    expected = getExpectedValue(rowNum, colNum);
                if (cur == 0) {
                    zeroRow = rowNum;
                    zeroCol = colNum;
                } else if (cur != expected) {
                    hamming++;
                    manhattan += getManhattan(rowNum, colNum, cur);
                }
                this.blocks[rowNum][colNum] = cur;
            }
        }
    }

    private int getExpectedValue(int rowNum, int colNum) {
        int ans = 1 + (rowNum * length) + colNum;
        return ans < length * length ? ans : 0;
    }

    /**
     * Get the Manhattan distance of one block.
     * @param rowNum - The current row number.
     * @param colNum - The current column number.
     * @param cur - The current element at that row and column.
     * @return - The Manhattan distance.
     */
    private int getManhattan(int rowNum, int colNum, int cur) {
        if (cur == 0) return 0;
        return Math.abs(rowNum - getRowNum(cur)) + Math.abs(colNum - getColNum(cur));
    }

    private int getRowNum(int val) {
        return (val - 1)/length;
    }

    private int getColNum(int val) {
        return (val - 1) % length;
    }

    private void swapNums() {
        int len = dimension();

        if (len <= 1) return;

        int oneRow = 0, oneCol = 0,
            twoRow = len - 1, twoCol = len - 1;

        if (zeroCol == oneCol) {
            oneCol++;
        } else if (zeroCol == twoCol) {
            twoCol--;
        }

        swap(oneRow, oneCol, twoRow, twoCol);
    }

    private void swap(int oneRow, int oneCol, int twoRow, int twoCol) {
        int expectedOne = getExpectedValue(oneRow, oneCol),
            expectedTwo = getExpectedValue(twoRow, twoCol),
            initialOne  = blocks[oneRow][oneCol],
            initialTwo  = blocks[twoRow][twoCol];

        // Decrement the Hamming and Manhattan distance due to the previous blocks.
        // We check if the value currently there is the value that's expected
        // there. If it isn't, then that value is contributing to the Hamming
        // distance. So decrement the Hamming distance.
        // The same logic applies to the Manhattan distance.
        if (initialOne != 0 && initialOne != expectedOne) {
            hamming--;
            manhattan -= getManhattan(oneRow, oneCol, initialOne);
        }

        if (initialTwo != 0 && initialTwo != expectedTwo) {
            hamming--;
            manhattan -= getManhattan(twoRow, twoCol, initialTwo);
        }

        // Now the current values (pre-swap) are not contributing to the distance
        // values. Now, we need to check if the post-swap values will. This will only
        // happen if the values are not zero and are not expected.
        if (initialOne != 0 && initialOne != expectedTwo) {
            hamming++;
            manhattan += getManhattan(twoRow, twoCol, initialOne);
        }

        if (initialTwo != 0 && initialTwo != expectedOne) {
            hamming++;
            manhattan += getManhattan(oneRow, oneCol, initialTwo);
        }

        // Now perform the actual swap.
        blocks[oneRow][oneCol] = initialTwo;
        blocks[twoRow][twoCol] = initialOne;
    }

    public int dimension() {
        // board dimension n
        return this.blocks.length;
    }

    public int hamming() {
        // number of blocks out of place
        return hamming;
    }

    public int manhattan() {
        // sum of Manhattan distances between blocks and goal
        return manhattan;
    }

    public boolean isGoal(){
        // is this board the goal board?
        return hamming == 0;
    }

    public Board twin(){
        // a board that is obtained by exchanging any pair of blocks
        Board twin = new Board(this.blocks);
        twin.swapNums();
        return twin;
    }

    public boolean equals(Object y){
        // does this board equal y?
        if (y == null) return false;

        if (y.getClass() != this.getClass()) return false;

        if (length != ((Board) y).dimension()) return false;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < ((Board) y).length; j++) {
                if (blocks[i][j] != ((Board) y).blocks[i][j]) return false;
            }
        }

        return true;
    }

    public Iterable<Board> neighbors(){
        // all neighboring boards

        ArrayList<Board> boards = new ArrayList<>();

        if (zeroRow - 1 >= 0) {
            Board temp = new Board(blocks);
            temp.swap(zeroRow, zeroCol, zeroRow - 1, zeroCol);
            temp.zeroRow--;
            boards.add(temp);
        }

        if (zeroRow + 1 < length) {
            Board temp = new Board(blocks);
            temp.swap(zeroRow, zeroCol, zeroRow + 1, zeroCol);
            temp.zeroRow++;
            boards.add(temp);
        }

        if (zeroCol - 1 >= 0) {
            Board temp = new Board(blocks);
            temp.swap(zeroRow, zeroCol, zeroRow, zeroCol - 1);
            temp.zeroCol--;
            boards.add(temp);
        }

        if (zeroCol + 1 < length) {
            Board temp = new Board(blocks);
            temp.swap(zeroRow, zeroCol, zeroRow, zeroCol + 1);
            temp.zeroCol++;
            boards.add(temp);
        }

        return boards;
    }

    public String toString(){
        // string representation of this board (in the output format specified below)
        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int cur = blocks[i][j];
                sb.append(cur);
                if (j != length - 1)
                    sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        // unit tests (not graded)
        int[][] testArr = {{5,8,7}, {1,4,0}, {3,2,6}};
        Board testBoard = new Board(testArr);
        System.out.println(testBoard);
        System.out.println("***********************************************");

        System.out.println(testBoard.hamming());

        /*
        Iterable<Board> neighbors = testBoard.neighbors();
        for(Board b: neighbors)
            System.out.println(b);
            */
    }
}
