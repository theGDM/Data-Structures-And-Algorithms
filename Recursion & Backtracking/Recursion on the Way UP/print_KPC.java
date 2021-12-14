import java.util.*;

public class print_KPC {
    public static String[] dtoc = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        printKPC(0, input, "");
        scn.close();
    }

    public static void printKPC(int idx, String input, String output) {
        // base case
        if (idx == input.length()) {
            System.out.println(output);
            return;
        }

        // faith
        for (Character letter : dtoc[input.charAt(idx) - '0'].toCharArray()) {
            printKPC(idx + 1, input, output + letter);
        }

    }

}