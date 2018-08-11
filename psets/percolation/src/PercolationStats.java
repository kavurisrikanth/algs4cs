import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    /* Class variables. */
    private double mean, stdDev, confLo, confHi;
    private final double confidenceConstant = 1.96;

    /*****
     * Constructor.
     * @param n - Grid size.
     * @param trials - Number of trials.
     */
    public PercolationStats(int n, int trials) {
        // Validation.
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("n and trails must be positive.");

        // Basic setup.
        mean = 0;
        stdDev = 0;
        confLo = 0;
        confHi = 0;
        double[] record = new double[trials];

        // The meat of this method.
        for (int i = 0; i < trials; i++) {
            // For each trial...

            // Create new Percolation object.
            Percolation p = new Percolation(n);

            // Until the system percolates, pick a closed slot at random and open it.
            while (!p.percolates()) {
                int row, col;

                do {
                    row = StdRandom.uniform(1, n + 1);
                    col = StdRandom.uniform(1, n + 1);
                } while (p.isOpen(row, col));

                p.open(row, col);
            }

            // Record the number of open slots it took.
            record[i] = ((double) p.numberOfOpenSites())/(n*n);
        }

        // Calculate the mean...


        // ...and the standard deviation, and the lower confidence level,
        // and the higher confidence level.
        mean = StdStats.mean(record);
        stdDev = StdStats.stddev(record);
        confLo = mean - (confidenceConstant * Math.sqrt(stdDev))/Math.sqrt(trials);
        confHi = mean + (confidenceConstant * Math.sqrt(stdDev))/Math.sqrt(trials);
    }

    /*****
     * Getter for the mean
     * @return - Mean
     */
    public double mean() {
        return mean;
    }

    /*****
     * Getter for the standard deviation
     * @return - Standard deviation
     */
    public double stddev() {
        return stdDev;
    }

    /*****
     * Getter for the low confidence
     * @return - Lower confidence level.
     */
    public double confidenceLo() {
        return confLo;
    }

    /*****
     * Getter for the high confidence
     * @return - Higher confidence level.
     */
    public double confidenceHi() {
        return confHi;
    }

    public static void main(String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("Number of arguments must be 2.");

        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("Mean:                 " + ps.mean());
        System.out.println("stddev:               " + ps.stddev());
        System.out.println("95% confidence level: [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
