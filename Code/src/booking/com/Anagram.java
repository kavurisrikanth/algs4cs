package booking.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> strings = new ArrayList<>();
        while (!line.isEmpty()) {
            strings.add(line);
            line = sc.nextLine();
        }
        sc.close();
    }
}
