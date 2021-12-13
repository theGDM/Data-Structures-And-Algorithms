import java.util.*;

public class get_KPC {

    public static String[] dtoc = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> subsets = getKPC(0, str);
        System.out.println(subsets);
        scn.close();
    }

    public static ArrayList<String> getKPC(int idx, String str) {
        // base case
        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        // faith
        ArrayList<String> smallAns = getKPC(idx + 1, str);

        ArrayList<String> ans = new ArrayList<>();

        for (Character letter : dtoc[str.charAt(idx) - '0'].toCharArray()) {
            for (String smallStr : smallAns) {
                ans.add(letter + smallStr);
            }
        }

        return ans;

    }

}