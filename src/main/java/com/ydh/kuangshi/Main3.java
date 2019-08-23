package com.ydh.kuangshi;

import java.util.*;

public class Main3 {

    public static boolean isOk(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = "";

        HashSet<String> correct = new HashSet<>();

        List<String> other = new ArrayList<>();

        line = scanner.nextLine();
        while (line != null && line.length() != 0) {
            line = scanner.nextLine();

            if (!isOk(line)) {
                other.add(line);
            } else {

                System.out.print(line + " ");
                int move = line.length() % 10;

                String newStr = "";
                newStr += line.substring(move, line.length());
                newStr += line.substring(0, move);
                correct.add(newStr);

            }
        }

        System.out.println();
        for (String s : other) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : correct) {
            System.out.print(s + " ");
        }
        System.out.println();

        Arrays.sort(correct.toArray(), Collections.reverseOrder());
        for (String s : correct) {
            System.out.print(s + " ");
        }
    }
}
