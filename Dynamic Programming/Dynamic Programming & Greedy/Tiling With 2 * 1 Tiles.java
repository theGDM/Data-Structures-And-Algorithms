import java.io.*;
import java.util.*;

public class Main {
    public static int tiling(int n){
        if(n == 0){
            return 1;
        }

        int ht = 0, vt = 0;
        if(n - 2 >= 0){
            ht = 1 * tiling(n - 2);
        }
        vt = 1 * tiling(n - 1);

        return ht + vt;
    }

    public static int tilingMemo(int n, int[] dp){
        if(n == 0){
            return dp[n] = 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int ht = 0, vt = 0;
        if(n - 2 >= 0){
            ht = 1 * tilingMemo(n - 2, dp);
        }
        vt = 1 * tilingMemo(n - 1, dp);

        return dp[n] = ht + vt;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // recursion
        // int res = tiling(n);
        // System.out.println(res);
        
        // memoization
        // int[] dp = new int[n + 1];
        // int res = tilingMemo(n, dp);
        // System.out.println(res);

        // tabulation
        int[] dp = new int[n + 1];
        for(int i = 0;i <= n; ++i){
            if(i == 0){
                dp[i] = 1;
                continue;
            }

            int ht = 0, vt = 0;
            if(i - 2 >= 0){
                ht = 1 * dp[i - 2];
            }
            vt = 1 * dp[i - 1];

            dp[i] = ht + vt;
        }

        System.out.println(dp[n]);
    }
}
