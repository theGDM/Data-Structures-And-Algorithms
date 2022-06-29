import java.io.*;
import java.util.*;

public class Main {
    //every weight have 2 choices whether to come in or not. so har bar hum aange badh rahe hai
    //yadi hum us wicket ko include karte hai to bhi, aur usko include nahi karte to bhi, aange 
    //badh rahe hai, kyuki har weight ko kebal ek baar hi use kar sakte;
    public static int knapsack(int n, int[] v, int[] w, int cap, int idx){
        //base case
        if(idx == n || cap == 0){
            return 0;
        }
        //idx == n means there is no wt left to include, and cap == 0, means our bag is full
        //now can not take any wt..

        int inc = 0, exc = 0;
        if(cap - w[idx] >= 0){
            inc = knapsack(n, v, w, cap - w[idx], idx + 1) + v[idx];
        }
        exc = knapsack(n, v, w, cap, idx + 1);
        return Math.max(inc, exc);
    }

    public static int knapsackMemo(int n, int[] v, int[] w, int cap, int idx, int[][] dp){
        //base case
        if(idx == n || cap == 0){
            return dp[idx][cap] = 0;
        }

        if(dp[idx][cap] != 0){
            return dp[idx][cap];
        }

        int inc = 0, exc = 0;
        if(cap - w[idx] >= 0){
            inc = knapsackMemo(n, v, w, cap - w[idx], idx + 1, dp) + v[idx];
        }
        exc = knapsackMemo(n, v, w, cap, idx + 1, dp);
        return dp[idx][cap] = Math.max(inc, exc);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] val = new int[n];
        for(int i = 0;i < n; ++i){
            val[i] = scn.nextInt();
        }

        int[] wt = new int[n];
        for(int i = 0;i < n; ++i){
            wt[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        // recursive approach
        // int ans = knapsack(n, val, wt, cap, 0);
        // System.out.println(ans);

        // memoization
        // int[][] dp = new int[n + 1][cap + 1];
        // int ans = knapsackMemo(n, val, wt, cap, 0, dp);
        // System.out.println(ans);

        // tabulation
        // int[][] dp = new int[n + 1][cap + 1];
        // for(int idx = n; idx >= 0; --idx){
        //     for(int c = 0; c <= cap; ++c){
        //         if(idx == n || c == 0){
        //             dp[idx][c] = 0;
        //             continue;
        //         }

        //         int inc = 0, exc = 0;
        //         if(c - wt[idx] >= 0){
        //             inc = dp[idx + 1][c - wt[idx]] + val[idx];
        //         }
        //         exc = dp[idx + 1][c];
        //         dp[idx][c] = Math.max(inc, exc);
        //     }
        // }

        // System.out.println(dp[0][cap]);

        // tabulation
        int[][] dp = new int[n + 1][cap + 1];
        for(int i = 0; i <= n; ++i){
            for(int j = 0; j <= cap; ++j){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }

                if(j >= wt[i - 1]){
                    int rCap = j - wt[i - 1]; //remaining balls, after ith player bats, these remaining ball will be used by the i - 1 team to make maximum run!
                    if(dp[i - 1][rCap] + val[i - 1] > dp[i - 1][j]){ //(i - 1) is the remaining team, and j is the total balls left
                        dp[i][j] = dp[i - 1][rCap] + val[i - 1];
                    }else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }else{
                     dp[i][j] = dp[i - 1][j]; //when i doesn't bat, it will left all j balls to previous team i.e (i - 1)
                }
            }
        }

        System.out.println(dp[n][cap]);
    }
}
