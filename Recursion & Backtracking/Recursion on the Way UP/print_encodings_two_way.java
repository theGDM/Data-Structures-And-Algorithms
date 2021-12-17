import java.util.*;

public class print_encodings_two_way {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        printEncodings(input, "");
        scn.close();
    }

    public static void printEncodings(String input, String output) {
        if (input.length() == 0) {
            // positive base case
            System.out.println(output);
            return;
        }

        // corner cases
        int ch1 = Integer.parseInt(input.substring(0, 1));

        if (ch1 >= 1 && ch1 <= 9) {
            String newInput1 = input.substring(1);
            printEncodings(newInput1, output + (char) ('a' + ch1 - 1));
        }

        if (input.length() >= 2) {
            int ch2 = Integer.parseInt(input.substring(0, 2));
            if (ch2 >= 10 && ch2 <= 26) {
                String newInput2 = input.substring(2);
                printEncodings(newInput2, output + (char) ('a' + ch2 - 1));
            }
        }
    }
}