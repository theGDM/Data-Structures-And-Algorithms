import java.util.*;

public class get_strairs_path {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> res = getStairPaths(n);
        System.out.println(res);
        scn.close();
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0){
            //positive base case -> 1 size
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        if(n < 0){
            //negative base case -> 0 size
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        
        //faith
        ArrayList<String> smallAns1 = getStairPaths(n - 1);
        ArrayList<String> smallAns2 = getStairPaths(n - 2);
        ArrayList<String> smallAns3 = getStairPaths(n - 3);
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(String str : smallAns1){
            ans.add(1 + str);
            // System.out.println(n + " - " + ans);
        }
        
        for(String str : smallAns2){
            ans.add(2 + str);
            // System.out.println(n + " - " + ans);
        }
        
        for(String str : smallAns3){
            ans.add(3 + str);
            // System.out.println(n + " - " + ans);
        }
        
        return ans;
    }

}