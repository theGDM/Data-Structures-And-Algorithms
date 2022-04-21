import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        if(n == 0 ||  k == 0 || k > n){ //wrong input
            return 0;
        }

        if(k == 1 || k == n){ //base case
            return 1;
        }

        long call1 = k * partitionKSubset(n - 1, k);//1st call
        long call2 = partitionKSubset(n - 1, k - 1);//2nd call
        return call1 + call2; 
    }

    public static long partitionKSubsetMemo(int n, int k, long dp[][]) {
        if(n == 0 || k == 0 || k > n){
            return dp[n][k] = 1;
        }

        if(k == 1 || k == n){ //base case
            return dp[n][k] = 1;
        }

        if(dp[n][k] != 0){
            return dp[n][k];
        }

        long call1 = k * partitionKSubsetMemo(n - 1, k, dp);//1st call
        long call2 = partitionKSubsetMemo(n - 1, k - 1, dp);//2nd call
        return dp[n][k] = call1 + call2; 
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        // recursion
        // long res = partitionKSubset(n, k);
        // System.out.println(res);

        //memoization
        // long[][] dp = new long[n + 1][k + 1];
        // long res = partitionKSubsetMemo(n, k, dp);
        // System.out.println(res);

        // tabulation
        long[][] dp = new long[n + 1][k + 1];
        for(int i = 0; i <= n; ++i){
            for(int j = 0;j <= k; ++j){
                if(i == 0 || j == 0 || j > i){
                    continue;
                }

                if(j == 1 || j == n){ //base case
                    dp[i][j] = 1;
                    continue;
                }

                long call1 = j * dp[i - 1][j];//1st call
                long call2 = dp[i - 1][j - 1];//2nd call
                dp[i][j] = call1 + call2; 
            }
        }

        System.out.println(dp[n][k]);
    }
}
