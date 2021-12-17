import java.util.*;

public class print_encodings_one_way {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        printEncodings(0, input, "");
        scn.close();
    }

    public static void printEncodings(int idx, String input, String output) {
        if (idx == input.length()) {
            // positive base case
            System.out.println(output);
            return;
        }

        // corner cases
        int ch1 = input.charAt(idx) - '0';
        if (ch1 >= 1 && ch1 <= 9) {
            printEncodings(idx + 1, input, output + (char) ('a' + ch1 - 1));
        }

        if (idx + 1 < input.length()) {
            int ch2 = (input.charAt(idx) - '0') * 10 + (input.charAt(idx + 1) - '0');
            if (ch2 >= 10 && ch2 <= 26) {
                printEncodings(idx + 2, input, output + (char) ('a' + ch2 - 1));
            }
        }
    }

}