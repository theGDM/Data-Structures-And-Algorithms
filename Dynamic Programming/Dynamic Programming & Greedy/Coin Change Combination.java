import java.io.*;
import java.util.*;

public class Main {

    public static int coinChange(int n, int[] denom, int amt, int idx){
        if(idx == n){
            if(amt == 0){
                return 1;
            }else{
                return 0;
            }
        }

        int ans = 0;
        if(amt - denom[idx]>= 0){
            ans += coinChange(n, denom, amt - denom[idx], idx);
        }

        ans += coinChange(n, denom, amt, idx + 1);

        return ans;
    }

    public static int coinChangeMemo(int n, int[] denom, int amt, int idx, int[][] dp){
        if(idx == n){
            if(amt == 0){
                return dp[idx][amt] = 1;
            }else{
                return dp[idx][amt] = 0;
            }
        }

        if(dp[idx][amt] != 0){
            return dp[idx][amt];
        }

        int ans = 0;
        if(amt - denom[idx]>= 0){
            ans +=coinChangeMemo(n, denom, amt - denom[idx], idx, dp);
        }

        ans += coinChangeMemo(n, denom, amt, idx + 1, dp);

        return dp[idx][amt] = ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] denom = new int[n];
        for(int i = 0;i < denom.length; ++i){
            denom[i] = scn.nextInt();
        }

        int amt = scn.nextInt();

        // recursive
        // int res = coinChange(n, denom, amt, 0);
        // System.out.println(res);

        // memoization
        // int[][] dp = new int[n + 1][amt + 1];
        // int res = coinChangeMemo(n, denom, amt, 0, dp);
        // System.out.println(res); 

        // tabulation
        int[][] dp = new int[n + 1][amt + 1];
        for(int idx = n; idx >= 0; --idx){
            for(int a = 0; a <= amt; ++a){
                if(idx == n){
                    if(a == 0){
                        dp[idx][a] = 1;
                        continue;
                    }else{
                        dp[idx][a] = 0;
                        continue;
                    }
                }

                int ans = 0;
                if(a >= denom[idx]){
                    ans += dp[idx][a - denom[idx]];
                }

                ans += dp[idx + 1][a];

                dp[idx][a] = ans;
            }
        }
        System.out.println(dp[0][amt]);
    }
}
