import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    /* Class variables. */
    private boolean[] open;
    private int numOpen;
    private final int n;
    private final WeightedQuickUnionUF qu;

    /*****
     * Basic constructor.
     * @param n - "Side length" of the grid.
     * @throws IllegalArgumentException - Thrown when proper conditions don't meet.
     */
    public Percolation(int n) {
        // Validation.
        if (n <= 0)
            throw new IllegalArgumentException("Number of sites must be positive.");

        // Basic setup.
        this.n = n;
        numOpen = 0;

        open = new boolean[2 + n * n];
        for (int i = 0; i < 2 + n * n; i++) {
            open[i] = false;
        }

        // Make two extra nodes to the top and bottom and do unions with the top and bottom rows.
        // Helps with efficient check of percolation.
        qu = new WeightedQuickUnionUF(2 + n * n);
    }


    /*****
     * Checks the (in)validity of the row and column numbers.
     * @param row - Row number
     * @param col - Column number
     * @return true or false
     */
    private boolean invalidRowOrColumnNumber(int row, int col) {
        return row <= 0 || row > n || col <= 0 || col > n;
    }

    /*****
     * Calculate the proper 1D index for the given row and column. Row and column start from 1.
     * Validation is not performed here; we simply calculate indices and then check it later.
     * @param row - Row number
     * @param col - Column number
     * @return - Index
     */
    private int calculateIndex(int row, int col) {
        int zeroBasedRow = row - 1, zeroBasedCol = col - 1;
        return (zeroBasedRow * n) + zeroBasedCol + 1;
    }

    /*****
     * Opens a slot in the grid. Row and column numbers start with 1.
     * @param row - Row number.
     * @param col - Column number
     */
    public void open(int row, int col) {
        // Validation.
        if (invalidRowOrColumnNumber(row, col))
            throw new IllegalArgumentException("Row or column not in range.");

        // Ignore a slot that's already open.
        if (!isOpen(row, col)) {

            // Calulate proper indices. Along with the current index, we also need
            // 4 other slots: Left, Right, Top, and Bottom.
            int arrayIndex   = calculateIndex(row, col),
                nextColIndex = calculateIndex(row, col + 1),
                prevColIndex = calculateIndex(row, col - 1),
                nextRowIndex = calculateIndex(row + 1, col),
                prevRowIndex = calculateIndex(row - 1, col);

            // This slot has been opened.
            open[arrayIndex] = true;

            /*
             * If left, right, top and bottom exist, and they are open, then do a union.
             */
            if (nextColIndex >= 1 + n * (row - 1) && nextColIndex <= n * row && open[nextColIndex])
                qu.union(arrayIndex, nextColIndex);

            if (prevColIndex >= 1 + n * (row - 1) && prevColIndex <= n * row && open[prevColIndex])
                qu.union(arrayIndex, prevColIndex);

            if (row < n && nextRowIndex >= 1 + n * (row) && nextRowIndex <= n * (row + 1) && open[nextRowIndex])
                qu.union(arrayIndex, nextRowIndex);

            if (row > 1 && prevRowIndex >= 1 + n * (row - 2) && prevRowIndex <= n * (row - 1) && open[prevRowIndex])
                qu.union(arrayIndex, prevRowIndex);

            if ((arrayIndex >= 1 && arrayIndex <= n) ||
                    (arrayIndex >= (n - 1) * n + 1 && arrayIndex <= n * n)) {
                if (arrayIndex >= 1 && arrayIndex <= n) {
                    qu.union(0, arrayIndex);
                }

                if (arrayIndex >= (n - 1) * n + 1 && arrayIndex <= n * n && isFull(row, col)) {
                    qu.union(arrayIndex, n * n + 1);
                }
            }

            // Keep track of number of open slots.
            numOpen++;
        }
    }

    /*****
     * Check if a slot is open. Row and column numbers start with 1.
     * @param row - Row number.
     * @param col - Column number.
     * @return true or false.
     */
    public boolean isOpen(int row, int col) {
        // Validation.
        if (invalidRowOrColumnNumber(row, col))
            throw new IllegalArgumentException("Row or column not in range.");

        // Basic array access.
        return open[calculateIndex(row, col)];
    }

    /*****
     * Basic getter.
     * @return - Number of open stores.
     */
    public int numberOfOpenSites() {
        return numOpen;
    }

    /*****
     * Check if a slot is full. Row and column numbers start with 1.
     * @param row - Row number
     * @param col - Column number
     * @return - true or false
     */
    public boolean isFull(int row, int col) {
        // Validation.
        if (invalidRowOrColumnNumber(row, col))
            throw new IllegalArgumentException("Row or column not in range.");

        return isOpen(row, col) && qu.connected(0, calculateIndex(row, col));
    }

    /*****
     * Check if the system percolates. Does this by checking if the top node and the bottom
     * node are connected.
     * @return - true or false
     */
    public boolean percolates() {
        return qu.connected(0, 1 + n * n);
    }

    /*****
     * Testing.
     * @param args
     */
    public static void main(String[] args) {
        /**/
        Percolation p = new Percolation(8);

        System.out.println(p.percolates() ? "Percolates" : "Does not percolate");
        System.out.println("Number of open sites: " + p.numberOfOpenSites() + "\n");

        p.open(1, 3);
        p.open(1, 4);
        p.open(1, 5);

        printOpenArray(p);

        p.open(2, 1);
        p.open(2, 4);
        p.open(2, 5);
        p.open(2, 6);
        p.open(2, 7);
        p.open(2, 8);

        System.out.println("***************************");
        printOpenArray(p);

        p.open(3, 1);
        p.open(3, 2);
        p.open(3, 3);
        p.open(3, 6);
        p.open(3, 7);

        System.out.println("***************************");
        printOpenArray(p);

        p.open(4, 3);
        p.open(4, 4);
        p.open(4, 6);
        p.open(4, 7);
        p.open(4, 8);

        System.out.println("***************************");
        printOpenArray(p);

        p.open(5, 2);
        p.open(5, 3);
        p.open(5, 4);
        p.open(5, 6);
        p.open(5, 7);

        System.out.println("***************************");
        printOpenArray(p);

        p.open(6, 2);
        p.open(6, 7);
        p.open(6, 8);

        System.out.println("***************************");
        printOpenArray(p);

        p.open(7, 1);
        p.open(7, 3);
        p.open(7, 5);
        p.open(7, 6);
        p.open(7, 7);
        p.open(7, 8);

        System.out.println("***************************");
        printOpenArray(p);

        p.open(8, 1);
        p.open(8, 2);
        p.open(8, 3);
        p.open(8, 4);
        p.open(8, 6);

        System.out.println("***************************");
        printOpenArray(p);


        System.out.println(p.percolates() ? "Percolates" : "Does not percolate");
        System.out.println("Number of open sites: " + p.numberOfOpenSites() + "\n");

    }

    /**/
    private static void printSlotStatus(Percolation p, int row, int col) {
        String ans = "Slot (" + row + ", " + col + ") is ",
                blocked = p.isOpen(row, col) ? "open" : "blocked",
                full = p.isFull(row, col) ? "full" : "empty";
        System.out.println(ans + blocked + " and " + full + ".");
    }

    private static void printOpenArray(Percolation p) {
        for (int i = 1; i <= p.n; i++) {
            for (int j = 1; j <= p.n; j++) {
                printSlotStatus(p, i, j);
            }
            System.out.println("");
        }
    }

}
