public class Quick {
    public static void sort(Comparable[] arr) {
        sort(arr, 0 , arr.length - 1);
    }

    private static void sort(Comparable[] arr, int start, int end) {
        if (start >= end) return;

        int pivot = partition(arr, start, end);
        System.out.println("pivot: " + pivot);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    private static int partition(Comparable[] arr, int start, int end) {
        Comparable pivot = arr[start];
        int i = start + 1, j = end;

        while (true) {
            while (i <= end && arr[i].compareTo(pivot) < 0) i++;

            while (j >= start && arr[j].compareTo(pivot) > 0) j--;

            if (i >= j)
                break;

            swap(arr, i, j);
        }

        swap(arr, start, j);
        return j;
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
