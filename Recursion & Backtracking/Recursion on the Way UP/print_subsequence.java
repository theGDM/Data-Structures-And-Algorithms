import java.util.*;

public class print_subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        printSS(0, input, "");
        scn.close();
    }

    public static void printSS(int idx, String input, String output) {
        // base case
        if (idx == input.length()) {
            System.out.println(output);
            return;
        }

        // extracting level character of string
        Character ch = input.charAt(idx);
        printSS(idx + 1, input, output + ch);// yes(faith)
        printSS(idx + 1, input, output);// no(faith)
    }
}