/**
 * Given three arrays of numbers, write a program to return an array in which all elements are
 * present in at least two of the three given arrays.
 */

package booking.com;

import java.util.*;

public class ThreeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        for (int i = 0; i < numTest; i++) {
            int numArr = sc.nextInt();
            int[][] arrays = new int[numArr][];
            for (int j = 0; j < numArr; j++) {
                int arrLen = sc.nextInt();
                sc.nextLine();
                arrays[j] = getIntArrayFromLine(sc.nextLine());
            }

            Integer[] result = go(arrays);
            System.out.println(result);
        }
        sc.close();
    }

    public static Integer[] go(int[][] arrays) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int[] arr: arrays) {
            goForArray(arr, counts);
        }

        List<Integer> ans = new ArrayList<>();
        for (int x: counts.keySet())
            if (counts.get(x) >= 2)
                ans.add(x);

        return ans.toArray(new Integer[0]);
    }

    private static void goForArray(int[] arr, Map<Integer, Integer> map) {
        Set<Integer> oneSet = new HashSet<>();
        for (int x: arr)
            oneSet.add(x);

        for (int x: oneSet) {
            int count = map.getOrDefault(x, 0);
            map.put(x, count + 1);
        }
    }

    private static int[] getIntArrayFromLine(String line) {
        String[] pieces = line.split(" ");
        return Arrays.stream(pieces).mapToInt(Integer::parseInt).toArray();
    }
}
