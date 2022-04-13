import java.io.*;
import java.util.*;

public class Main {
    // Wrong approach
    // public static int coinChange(int[] denom, int amt){
    //     if(amt == 0){
    //         return 1;
    //     }

    //     int ans = 0;
    //     for(int i = 0;i < denom.length; ++i){
    //         if(amt - denom[i] >= 0){
    //             ans += coinChange(denom, amt - denom[i]);
    //         }
    //     }

    //     return ans;
    // }

    public static int coinChange(int n, int[] denom, int amt, int idx){
        if(idx == n){
            if(amt == 0){
                return 1;
            }else{
                return 0;
            }
        }

        int ans = 0;
        if(amt >= denom[idx]){
            ans += coinChange(n, denom, amt - denom[idx], idx);
        }

        ans += coinChange(n, denom, amt, idx + 1);

        return ans;
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

        // tabulation
        int[][] dp = new int[n + 1][amt + 1];
        for(int idx = n; idx >= n; --idx){
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
                if(amt >= denom[idx]){
                    ans += dp[idx][a - denom[idx]];
                }

                ans += dp[idx + 1][a];

                dp[idx][a] = ans;
            }

            System.out.println(dp[0][amt]);
        }
        
    }
}
