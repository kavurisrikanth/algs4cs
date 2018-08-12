public class DutchNationalFlag {

    public static void sort(String[] arr) {
        int i = 0, j = arr.length - 1, iter = 1, numColor = 0, numSwap = 0;
        while (iter <= j) {
            String cur = arr[iter];
            numColor++;

            switch (cur) {
                case "red":
                    // Red comes first
                    exch(arr, i++, iter);
                    numSwap++;
                    break;
                case "blue":
                    // Blue is to the end
                    exch(arr, j--, iter);
                    numSwap++;
                    break;
                case "white":
                    // Leave white where it is.
                    iter++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid color found: " + cur);
            }
        }

        System.out.println("Array length: " + arr.length);
        System.out.println("Color accesses: " + numColor + ", Swaps: " + numSwap);
    }

    private static void exch(String[] arr, int one, int two) {
        String temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
