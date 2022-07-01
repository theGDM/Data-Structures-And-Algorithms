import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();
    
        int[][] cost = new int[n][c];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < c; ++j){
                cost[i][j] = scn.nextInt();
            }
        }

        //tabulation
        int[][] dp = new int[cost.length][cost[0].length];
        for(int j = 0; j < cost[0].length; ++j){
            dp[0][j] = cost[0][j];
        }

        for(int i = 1; i < n; ++i){
            for(int j = 0; j < c; ++j){
                int min = getMinInRow(i - 1, j, dp); //get min in prev row of dp, excluding jth currnt idx
                dp[i][j] = cost[i][j] + min;
            }
        }

        int ans = dp[dp.length - 1][0];
        for(int j = 0; j < c; ++j){
            ans = Math.min(ans, dp[dp.length - 1][j]);
        }

        System.out.println(ans);
    }

    public static int getMinInRow(int r, int c, int[][] dp){
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < dp[0].length; ++k){
            if(k == c){
                continue;
            }

            min = Math.min(min, dp[r][k]);
        }

        return min;
    }
}
