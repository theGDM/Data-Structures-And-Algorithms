import java.util.*;

public class get_subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> res = gss(0, str);
        System.out.println(res);
        scn.close();
    }

    public static ArrayList<String> gss(int idx, String str) {
        //base case, return a arraylist of size 1
        if(idx == str.length()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        //faith
        ArrayList<String> smallAns = gss(idx + 1, str);
        
        ArrayList<String> ans = new ArrayList<>();
        
        //no choice of, ith element of string
        for(int i = 0;i < smallAns.size(); ++i){
            ans.add(smallAns.get(i));
        }
        
        //yes choice of, ith element of string
        for(int i = 0;i < smallAns.size(); ++i){
            ans.add(str.charAt(idx) + smallAns.get(i));
        }
        
        return ans;
        
    }

}