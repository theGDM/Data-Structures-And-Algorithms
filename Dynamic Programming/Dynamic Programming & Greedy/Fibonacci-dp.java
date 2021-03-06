import java.util.*;

public class fibonacci {
    public static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int ans = fibo(n - 1) + fibo(n - 2);
        return ans;
    }

    public static void recursive(int n) {
        int res = fibo(n);
        System.out.println(res);
    }

    public static int memoFibo(int n, int[] memo) {
        if (n == 0 || n == 1) {
            memo[n] = n;
            return n;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int ans = memoFibo(n - 1, memo) + memoFibo(n - 2, memo);
        memo[n] = ans;
        return ans;
    }

    public static void memoization(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int res = memoFibo(n, memo);
        System.out.println(res);
    }

    public static void tabulation(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            if (i == 0 || i == 1) {
                dp[i] = i;
                continue;
            }

            int ans = dp[i - 1] + dp[i - 2];
            dp[i] = ans;
        }

        System.out.println(dp[n]);
    }

    public static void so(int n) {
        int prev = 1, sprev = 0;
        for (int i = 2; i <= n; ++i) {
            int curr = prev + sprev;
            sprev = prev;
            prev = curr;
        }
        System.out.println(prev);
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // recursive(n);
        // memoization(n);
        // tabulation(n);
        so(n);
        scn.close();
    }

}
