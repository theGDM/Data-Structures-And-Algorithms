import java.io.*;
import java.util.*;

public class Main {

    static String[] kpc = {".;" ,"abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ans = getKPC(0, str);
        System.out.println(ans);
    }

    public static ArrayList<String> getKPC(int idx, String str) {
        //base case
        if(idx == str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        //faith
        ArrayList<String> tempAns = getKPC(idx + 1, str);

        //meeting expectation with faith
        ArrayList<String> ans = new ArrayList<>();

        String keyComb = kpc[str.charAt(idx) - '0'];
        for(int i = 0; i < keyComb.length(); ++i){
            for(int j = 0;j < tempAns.size(); ++j){
                ans.add(keyComb.charAt(i) + tempAns.get(j));
            }
        }
        return ans;
    }

}
