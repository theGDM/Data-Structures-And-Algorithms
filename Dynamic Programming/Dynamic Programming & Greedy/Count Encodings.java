import java.io.*;
import java.util.*;

public class Main {
    //print and count encodings
    public static int countPrintencodings(String input, String output){
        if(input.length() == 0){
            System.out.println(output);
            return 1;
        }

        int ans = 0;
        int ch1 = Integer.parseInt(input.substring(0, 1));

        if (ch1 >= 1 && ch1 <= 9) {
            String newInput1 = input.substring(1);
            ans += countPrintencodings(newInput1, output + (char) ('a' + ch1 - 1));
        }

        if (input.length() >= 2) {
            int ch2 = Integer.parseInt(input.substring(0, 2));
            if (ch2 >= 10 && ch2 <= 26) {
                String newInput2 = input.substring(2);
                ans += countPrintencodings(newInput2,output + (char) ('a' + ch2 - 1));
            }
        }

        return ans;
    }

    public static int countEncodings(String input, int idx){
        if(idx == input.length()){
            return 1;
        }

        int ans = 0;
        if(input.charAt(idx) >= '1' && input.charAt(idx) <= '9'){
            ans += countEncodings(input, idx + 1);
        }

        if(idx + 1 < input.length() 
                && ((input.charAt(idx) == '1' && input.charAt(idx + 1) <= '9') 
                || (input.charAt(idx) == '2' && input.charAt(idx + 1) <= '6'))){
            ans += countEncodings(input, idx + 2);
        }

        return ans;
    }

    public static int countEncodingsMemo(String input, int idx, int[] dp){
        if(idx == input.length()){
            return dp[idx] = 1;
        }

        if(dp[idx] != 0){
            return dp[idx];
        }

        int ans = 0;
        if(input.charAt(idx) >= '1' && input.charAt(idx) <= '9'){
            ans += countEncodingsMemo(input, idx + 1, dp);
        }

        if(idx + 1 < input.length() 
                && ((input.charAt(idx) == '1' && input.charAt(idx + 1) <= '9') 
                || (input.charAt(idx) == '2' && input.charAt(idx + 1) <= '6'))){
            ans += countEncodingsMemo(input, idx + 2, dp);
        }

        return dp[idx] = ans;

    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        // one way
        // int ans = countPrintencodings(str, "");
        // System.out.println(ans);

        // second way
        // int ans = countEncodings(str, 0);
        // System.out.println(ans);

        // memoization
        // int dp[] = new int[str.length() + 1];
        // int ans = countEncodingsMemo(str, 0, dp);
        // System.out.println(ans);

        // tabulation
        // int dp[] = new int[str.length() + 1];
        // for(int idx = str.length(); idx >= 0; --idx){
        //     if(idx == str.length()){
        //         dp[idx] = 1;
        //         continue;
        //     }

        //     int ans = 0;
        //     if(str.charAt(idx) >= '1' && str.charAt(idx) <= '9'){
        //         ans += dp[idx + 1];
        //     }

        //     if(idx + 1 < str.length() 
        //             && ((str.charAt(idx) == '1' && str.charAt(idx + 1) <= '9') 
        //             || (str.charAt(idx) == '2' && str.charAt(idx + 1) <= '6'))){
        //         ans += dp[idx + 2];
        //     }

        //     dp[idx] = ans;
        // }
        // System.out.println(dp[0]);

        // space optimization
        int nxt = 0, nxtknxt = 0;
        for(int idx = str.length(); idx >= 0; --idx){
            if(idx == str.length()){
                nxt = 1;
                continue;
            }

            int ans = 0;
            if(str.charAt(idx) >= '1' && str.charAt(idx) <= '9'){
                ans += nxt;
            }

            if(idx + 1 < str.length() 
                    && ((str.charAt(idx) == '1' && str.charAt(idx + 1) <= '9') 
                    || (str.charAt(idx) == '2' && str.charAt(idx + 1) <= '6'))){
                ans += nxtknxt;
            }

            nxtknxt = nxt;
            nxt = ans;
        }
        System.out.println(nxt);
    } 
}
