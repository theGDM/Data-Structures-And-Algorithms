import java.io.*;
import java.util.*;

public class Main {
    public static int minCost(int r, int[][] color, int check){
        if(r == color.length){
            return 0;
        }

        int pos = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < 3; ++i){
            if(color[r][i] < min && i != check){
                min = color[r][i];
                pos = i;
            }
        }
 
        int res = minCost(r + 1, color, pos);
        return res + min;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] color = new int[n][3];
        for(int i = 0;i < n; ++i){
            for(int j = 0;j < 3; ++j){
                color[i][j] = scn.nextInt();
            }
        }

        // recursion 
        int pos = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < 3; ++i){
            if(color[0][i] < min){
                min = color[0][i];
                pos = i;
            }
        }
        
        // int res = minCost(1, color, pos);
        // System.out.println(res + min);
        
        // tabulation 
        long[][] dp = new long[n][3];

        dp[0][0] = color[0][0];
        dp[0][1] = color[0][1];
        dp[0][2] = color[0][2];

        for(int i = 1; i < n; ++i){
            dp[i][0] = color[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = color[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = color[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        long ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        System.out.println(ans);
    }
}
