package helpers;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        String x = "hello";
        switch (x) {
            case "hello":
                System.out.println("world");
                break;
            case "world":
                System.out.println("hello");
                break;
        }

        Scanner sc = new Scanner(System.in);
        String in;
        do {
            in = sc.nextLine();
            String[] pieces = in.split(" ");
            String t = pieces[1],
                    s = pieces[0];

            System.out.println("Number of matches: " + getCount(s, t));
        } while (!in.equals("0"));

        sc.close();
    }

    private static int getCount(String s, String t) {
        int i = 0, j = 0, ans = 0, temp = 0;
        boolean found = false;

        while (i < t.length() - s.length() + 1) {
            found = true;

            temp = i;
            j = 0;
            while (j < s.length() && (t.charAt(i) == s.charAt(j))) {
                i++;
                j++;
            }

            if (j == s.length()) ans++;
            else if (i == 0) i++;
            i = temp + 1;
        }

        return ans;
    }
}
