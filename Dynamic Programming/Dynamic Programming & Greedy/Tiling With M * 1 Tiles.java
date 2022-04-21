import java.io.*;
import java.util.*;

public class Main {
    public static int tiling(int n, int m){
        if(n == 0){
            return 1;
        }

        int ht = 0, vt = 0;
        if(n - m >= 0){
            ht = 1 * tiling(n - m, m);//2 tiles horizontaly
        }
        vt = 1 * tiling(n - 1, m);//1 tile vertically

        return ht + vt;
    }

    public static int memoTiling(int n, int m, int[] dp){
        if(n == 0){
            return dp[n] = 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int ht = 0, vt = 0;
        if(n - m >= 0){
            ht = 1 * memoTiling(n - m, m, dp);//2 tiles horizontaly
        }
        vt = 1 * memoTiling(n - 1, m, dp);//1 tile vertically

        return dp[n] = ht + vt;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        // recursion
        // int ans = tiling(n, m);
        // System.out.println(ans);

        // memoization
        // int[] dp = new int[n + 1];
        // int ans = memoTiling(n, m, dp);
        // System.out.println(ans);

        // tabulation
        int[] dp = new int[n + 1];
        for(int i = 0;i <= n; ++i){
            if(i == 0){
                dp[i] = 1;
                continue;
            }

            int ht = 0, vt = 0;
            if(i - m >= 0){
                ht = 1 * dp[i - m];//2 tiles horizontaly
            }
            vt = 1 * dp[i - 1];//1 tile vertically

            dp[i] = ht + vt;
        }

        System.out.println(dp[n]);
    }
}
