package sorting;

import java.util.Arrays;

public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        aux = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start)/2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);

        merge(arr, start, mid, mid + 1, end);
    }

    private static void merge(Comparable[] arr, int start_1, int end_1, int start_2, int end_2) {
        if (end_1 + 1 - start_1 >= 0) System.arraycopy(arr, start_1, aux, start_1, end_1 + 1 - start_1);

        int i = start_1, j = start_2, k = start_1;
        while (i <= end_1 && j <= end_2) {
            if (aux[i].compareTo(arr[j]) <= 0) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = arr[j++];
            }
        }

        while (i <= end_1) {
            arr[k++] = aux[i++];
        }

        while (j <= end_2) {
            arr[k++] = arr[j++];
        }
    }
}
