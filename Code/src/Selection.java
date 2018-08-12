public class Selection {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min]))
                    min = j;
            }

            exch(arr, i, min);
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
