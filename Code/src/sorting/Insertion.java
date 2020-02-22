package sorting;

public class Insertion {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exch(arr, j, j - 1);
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
