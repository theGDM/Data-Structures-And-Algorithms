import java.io.*;
import java.util.*;

public class Main {

    public static int coinChange(int[] denom, int amt){
        if(amt == 0){
            return 1;
        }

        int ans = 0;
        for(int i = 0;i < denom.length; ++i){
            if(amt - denom[i] >= 0){
                ans += coinChange(denom, amt - denom[i]);
            }
        }

        return ans;
    }

    public static int memoCoinChange(int[] denom, int amt, int[] dp){
        if(amt == 0){
            return dp[amt] = 1;
        }

        if(dp[amt] != 0){
            return dp[amt];
        }

        int ans = 0;
        for(int i = 0;i < denom.length; ++i){
            if(amt - denom[i] >= 0){
                ans += memoCoinChange(denom, amt - denom[i], dp);
            }
        }

        return dp[amt] = ans;
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
        // int res = coinChange(denom, amt);
        // System.out.println(res);

        // memoization
        // int[] dp = new int[amt + 1];
        // int res = memoCoinChange(denom, amt, dp);
        // System.out.println(res);

        // tabulation
        int[] dp = new int[amt + 1];
        for(int a = 0; a <= amt; ++a){
            if(a == 0){
                dp[a] = 1;
                continue;
            }

            int ans = 0;
            for(int i = 0;i < denom.length; ++i){
                if(a - denom[i] >= 0){
                    ans += dp[a - denom[i]];
                }
            }

            dp[a] = ans;
        }

        System.out.println(dp[amt]);
    }
}
