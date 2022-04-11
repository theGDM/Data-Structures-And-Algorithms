import java.io.*;
import java.util.*;

public class Main {
    public static int dig(int n, int m, int[][] mine, int r, int c){
        if(c == m - 1){ //base case, right most wall
            return mine[r][c];
        }

        int ans = Integer.MIN_VALUE;
        //right-up call
        if(r - 1 >= 0){
            ans = Math.max(ans, dig(n, m, mine, r - 1, c + 1));
        }
        //right call
        ans = Math.max(ans, dig(n, m, mine, r, c + 1));
        //right-down call
        if(r + 1 <= n - 1){
            ans = Math.max(ans, dig(n, m, mine, r + 1, c + 1));
        }

        return ans + mine[r][c]; //adding current cell value to the returned max gold 
    }

    public static int memoDig(int n, int m, int[][] mine, int r, int c, int[][] dp){
        if(c == m - 1){ //base case, right most wall
            return dp[r][c] = mine[r][c];
        }

        if(dp[r][c] != 0){
            return dp[r][c];
        }

        int ans = Integer.MIN_VALUE;
        //right-up call
        if(r - 1 >= 0){
            ans = Math.max(ans, memoDig(n, m, mine, r - 1, c + 1, dp));
        }
        //right call
        ans = Math.max(ans, memoDig(n, m, mine, r, c + 1, dp));
        //right-down call
        if(r + 1 <= n - 1){
            ans = Math.max(ans, memoDig(n, m, mine, r + 1, c + 1, dp));
        }

        return dp[r][c] = (ans + mine[r][c]); //adding current cell value to the returned max gold 
    }


    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mine = new int[n][m];
        for(int i = 0;i < n; ++i){
            for(int j = 0;j < m; ++j){
                mine[i][j] = scn.nextInt();
            }
        }
        // recursive
        // int ans = Integer.MIN_VALUE;
        // for(int r = 0; r < n; ++r){
        //     ans = Math.max(ans, dig(n, m, mine, r, 0));
        // }
        // System.out.println(ans);

        // memoization
        // int[][] dp = new int[n][m];
        // int ans = Integer.MIN_VALUE;
        // for(int r = 0; r < n; ++r){
        //     ans = Math.max(ans, memoDig(n, m, mine, r, 0, dp));
        // }
        // System.out.println(ans);

        // tabulation
        int[][] dp = new int[n][m];
        int res = Integer.MIN_VALUE;
        for(int c = m - 1; c >= 0; --c){
            for(int r = 0;r < n; ++r){
                if(c == m - 1){ //base case
                    dp[r][c] = mine[r][c];
                    continue;
                }

                int ans = Integer.MIN_VALUE;
                //right-up call
                if(r - 1 >= 0){
                    ans = Math.max(ans, dp[r - 1][c + 1]);
                }
                //right call
                ans = Math.max(ans, dp[r][c + 1]);
                //right-down call
                if(r + 1 <= n - 1){
                    ans = Math.max(ans, dp[r + 1][c + 1]);
                }

                dp[r][c] = (ans + mine[r][c]); //adding current cell value to the returned max gold 
            }
        }

        //getting max from first coloumn 
        for(int r = 0; r < n; ++r){
            res = Math.max(res, dp[r][0]);
        }

        System.out.println(res);
    }

}
