import java.io.*;
import java.util.*;

public class Main {
    public static int climbStairMinMove(int idx, int n, int[] jumps){
        if(idx == n){
            return 0;//means we are at top most step, so min moves to go at top equal to 0
        }

        int ans = Integer.MAX_VALUE;
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(jump + idx <= n){
                int currMinMove = climbStairMinMove(idx + jump, n, jumps);
                if(currMinMove < ans){
                    ans = currMinMove;
                }
            }
        }

        if(ans != Integer.MAX_VALUE){
            ans += 1;
        }

        return ans;
    }

    public static int climbStairMemo(int idx, int n, int[] jumps, int[] dp){
        if(idx == n){
            return dp[idx] = 0;//means we are at top most step, so min moves to go at top equal to 0
        }

        if(dp[idx] != Integer.MAX_VALUE){
            return dp[idx];
        }

        int ans = Integer.MAX_VALUE;
        for(int jump = 1; jump <= jumps[idx]; ++jump){
            if(jump + idx <= n){
                int currMinMove = climbStairMemo(idx + jump, n, jumps, dp);
                if(currMinMove < ans){
                    ans = currMinMove;
                }
            }
        }

        if(ans != Integer.MAX_VALUE){
            ans += 1;
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
        // int ans = climbStairMinMove(0, n, jumps);
        // System.out.println(ans);

        //memoization
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // int ans = climbStairMemo(0, n, jumps, dp);
        // System.out.println(ans);

        //tabulation
        int[] dp = new int[n + 1];
        for(int idx = n; idx >= 0; --idx){
            if(idx == n){
                dp[idx] = 0;//means we are at top most step, so min moves to go at top equal to 0
                continue;
            }

            int ans = Integer.MAX_VALUE;
            for(int jump = 1; jump <= jumps[idx]; ++jump){
                if(jump + idx <= n){
                    int currMinMove = climbStairMemo(idx + jump, n, jumps, dp);
                    if(currMinMove < ans){
                        ans = currMinMove;
                    }
                }
            }

            if(ans != Integer.MAX_VALUE){
                ans += 1;
            }

            dp[idx] = ans;
        }
        System.out.println(dp[0]);
    }
}
