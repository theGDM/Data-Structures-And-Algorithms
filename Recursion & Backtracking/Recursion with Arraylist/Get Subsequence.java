import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ans = gss(0, str);
        System.out.println(ans);
    }

    public static ArrayList<String> gss(int idx, String str) {
        //base case
        if(idx == str.length()){
           ArrayList<String> base = new ArrayList<>(); 
           base.add("");
           return base;
        }

        //faith
        ArrayList<String> tempAns = gss(idx + 1, str);
        ArrayList<String> ans = new ArrayList<>(); 

        //Every level's element will gitve its choice
        //no choice of level's element
        for(int i = 0;i < tempAns.size(); ++i){
            ans.add(tempAns.get(i));
        }

        //yes choice of level's element
        for(int i = 0;i < tempAns.size(); ++i){
            ans.add(str.charAt(idx) + tempAns.get(i));
        }

        return ans;
    }

}
