import java.io.*;
import java.util.*;

public class Main {
    public static int maxSum(int n, int idx, int lastTaken, int[] arr){
         if(idx >= n){
             return 0;
         }

         if(lastTaken == 1){
             int exc = maxSum(n, idx + 1, 0, arr);
             return exc;
         }

         //if current index is taken into consideration, then call is made to next to next index
         int inc = maxSum(n, idx + 1, 1, arr) + arr[idx];
         //if current index is not taken into consideration, then call is made to next index
         int exc = maxSum(n, idx + 1, 0, arr);
         return Math.max(inc, exc);
    }

    public static int maxSumMemo(int n, int idx, int lastTaken, int[] arr, int[][] dp){
         if(idx >= n){
             return dp[idx][lastTaken] = 0;
         }

         if(dp[idx][lastTaken] != 0){
             return dp[idx][lastTaken];
         }

         if(lastTaken == 1){
             int exc = maxSumMemo(n, idx + 1, 0, arr, dp);
             return dp[idx][lastTaken] = exc;
         }

         int inc = maxSumMemo(n, idx + 1, 1, arr, dp) + arr[idx];
         int exc = maxSumMemo(n, idx + 1, 0, arr, dp);
         return dp[idx][lastTaken] = Math.max(inc, exc);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0;i < n; ++i){
            arr[i] = scn.nextInt();
        }

        // recursion
        // int res = maxSum(n, 0, 0, arr);
        // System.out.println(res);

        // memoization
        // int[][] dp = new int[n + 1][2];
        // int res = maxSumMemo(n, 0, 0, arr, dp);
        // System.out.println(res);

        //tabulation
        int[][] dp = new int[n + 1][2];
        for(int idx = n; idx >= 0; --idx){
            for(int lastTaken = 0; lastTaken <= 1; ++lastTaken){
                if(idx >= n){
                    dp[idx][lastTaken] = 0;
                    continue;
                }

                if(lastTaken == 1){
                    int exc = dp[idx + 1][0];
                    dp[idx][lastTaken] = exc;
                }

                int inc = dp[idx + 1][1] + arr[idx];
                int exc = dp[idx + 1][0];
                dp[idx][lastTaken] = Math.max(inc, exc);
            }
        }

        // for(int i = 0;i <= n; ++i){
        //     for(int j = 0;j < 2; ++j){
        //         System.err.print(dp[i][j] + " ");
        //     }
        //     System.err.println();
        // }
        System.out.println(dp[0][0]);
    }
}
