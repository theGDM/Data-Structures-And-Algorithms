import java.util.*;

public class print_permutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        printPermutations(input, "");
        scn.close();
    }

    public static void printPermutations(String input, String output) {
        // base case
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        // faith
        for (int i = 0; i < input.length(); ++i) {
            String newInput = input.substring(0, i) + input.substring(i + 1);
            printPermutations(newInput, output + input.charAt(i));
        }
    }
}