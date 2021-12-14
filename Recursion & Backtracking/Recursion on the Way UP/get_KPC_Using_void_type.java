import java.util.*;

public class get_KPC_Using_void_type {
    public static String[] dtoc = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        ArrayList<String> res = new ArrayList<>();
        printKPC(0, input, "", res);
        System.out.println(res);
        scn.close();
    }

    public static void printKPC(int idx, String input, String output, ArrayList<String> res) {
        // base case
        if (idx == input.length()) {
            res.add(output);
            return;
        }

        // faith
        for (Character letter : dtoc[input.charAt(idx) - '0'].toCharArray()) {
            printKPC(idx + 1, input, output + letter, res);
        }

    }

}