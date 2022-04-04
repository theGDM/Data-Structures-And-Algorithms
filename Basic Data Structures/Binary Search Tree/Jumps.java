import java.io.*;
import java.util.*;

public class Main {

    public static int climbStair(int idx, int n, int[] jumps){
        if(idx == n){
            return 1;
        }

        int ans = 0;
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            ans += climbStair(idx + jump, n, jumps);
        }

        return ans;
    }

    public static int memoClimbStair(int idx, int n, int[] jumps, int[] dp){
        if(idx == n){
            return dp[idx] = 1;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int ans = 0;
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(idx + jump <= n){
                ans += memoClimbStair(idx + jump, n, jumps, dp);
            }
        }
        
        return dp[idx] = ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] jumps = new int[n];
        for(int i = 0;i < n; ++i){
            jumps[i] = scn.nextInt();
        }

        //recursive
        // int res = climbStair(0, n, jumps);
        // System.out.println(res);

        //memoization
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // int res = memoClimbStair(0, n, jumps, dp);
        // System.out.println(res);

        //tabulation
        int[] dp = new int[n + 1];
        for(int idx = n; idx >= 0; --idx){
            if(idx == n){
                dp[idx] = 1;
                continue;
            }

            int ans = 0;
            for(int jump = 1; jump <= jumps[idx]; ++jump){
                if(idx + jump <= n){
                    ans += dp[idx + jump];
                }
            }
            
            dp[idx] = ans;
        }

        System.out.println(dp[0]);
    }

}
