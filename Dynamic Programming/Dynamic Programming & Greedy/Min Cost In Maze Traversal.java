import java.io.*;
import java.util.*;

public class Main {

    public static int mazeMinCost(int r, int c, int n, int m, int[][] maze){
        if(r == n - 1 && c == m - 1){
            return maze[r][c];
        }

        int ans = Integer.MAX_VALUE;
        if(r + 1 <= n - 1){
            ans = Math.min(ans, mazeMinCost(r + 1, c, n, m, maze));
        }
        
        if(c + 1 <= m - 1){
            ans = Math.min(ans, mazeMinCost(r, c + 1, n, m, maze));
        }
        
        return ans + maze[r][c];
    }

    public static int memoMazeMinCost(int r, int c, int n, int m, int[][] maze, int[][] dp){
        if(r == n - 1 && c == m - 1){
            return dp[r][c] = maze[r][c];
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int ans = Integer.MAX_VALUE;
        if(r + 1 <= n - 1){
            ans = Math.min(ans, memoMazeMinCost(r + 1, c, n, m, maze, dp));
        }
        
        if(c + 1 <= m - 1){
            ans = Math.min(ans, memoMazeMinCost(r, c + 1, n, m, maze, dp));
        }
        
        return dp[r][c] = (ans + maze[r][c]);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] maze = new int[n][m];
        for(int i = 0;i < n; ++i){
            for(int j = 0;j < m; ++j){
                maze[i][j] = scn.nextInt();
            }
        }
        // recursion
        // int res = mazeMinCost(0, 0, n, m, maze);
        // System.out.println(res);

        //memoization T.C : o(n^2) S.C. : o(n^2)
        // int[][] dp = new int[n][m];
        // for(int i = 0;i < n; ++i){
        //     Arrays.fill(dp[i], -1);
        // }

        // int res = memoMazeMinCost(0, 0, n, m, maze, dp);
        // System.out.println(res);

        //tabulation T.C : o(n^2) S.C. : o(n^2)
        // int[][] dp = new int[n][m];
        // for(int r = n - 1;r >= 0; --r){
        //     for(int c = m - 1;c >= 0; --c){
        //         if(r == n - 1 && c == m - 1){
        //             dp[r][c] = maze[r][c];
        //             continue;
        //         }

        //         int ans = Integer.MAX_VALUE;
        //         if(r + 1 <= n - 1){
        //             ans = Math.min(ans, dp[r + 1][c]);
        //         }
                
        //         if(c + 1 <= m - 1){
        //             ans = Math.min(ans, dp[r][c + 1]);
        //         }
                
        //         dp[r][c] = ans + maze[r][c];
        //     }
        // }

        // System.out.println(dp[0][0]);
        // for(int r = 0;r < n; ++r){
        //     for(int c = 0;c < m; ++c){
        //       System.out.print(dp[r][c] + " ");  
        //     }
        //     System.out.println();
        // }

        //space optimiztion T.C : o(n^2) S.C. : o(n)
        int[] dp = new int[m];
        dp[m - 1] = maze[n - 1][m - 1];
        for(int c = m - 2;c >= 0; --c){
            dp[c] += dp[c + 1] + maze[n - 1][c];
        }

        for(int r = n - 2;r >= 0; --r){
            for(int c = m - 1;c >= 0; --c){

                int ans = Integer.MAX_VALUE;
                if(r + 1 <= n - 1){
                    ans = Math.min(ans, dp[c]);
                }
                
                if(c + 1 <= m - 1){
                    ans = Math.min(ans, dp[c + 1]);
                }
                
                dp[c] = ans + maze[r][c];
            }
        }

        System.out.println(dp[0]);
    }
}
