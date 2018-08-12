import java.lang.Math;
import java.util.ArrayList;

public class Shell {
    public static void sort(Comparable[] arr) {
        // Find proper sequence. Try Sedgewick's.
        ArrayList<Integer> hVals = new ArrayList<>();

        int h = 1;
        while (h < arr.length) {
            hVals.add(h);
            h = (h % 2 == 0 ? (int)(1 + 9 * (Math.pow(2, h) - Math.pow(2, h/2))) : (int)(1 + (8 * Math.pow(2, h)) - (6 * Math.pow(2, (h + 1)/2))));
        }

        Object[] hValsArr = hVals.toArray();
        for (int i = hValsArr.length - 1; i >= 0; i--) {
            Integer oneH = (Integer) hValsArr[i];

            for (int j = oneH; j < arr.length; j++) {
                for (int k = j; k >= oneH && less(arr[k], arr[k - 1]) ; k -= oneH) {
                    exch(arr, k, k - 1);
                }
            }
        }
    }

    private static boolean less(Comparable one, Comparable other) {
        return one.compareTo(other) < 0;
    }

    private static void exch(Comparable[] arr, int one, int two) {
        Comparable temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
