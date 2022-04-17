import java.io.*;
	import java.util.*;

	public class Main {
	
		public static int knapsack(int n, int[] v, int[] w, int cap, int idx){
			//base case
			if(idx == n || cap == 0){
				return 0;
			}

			int inc = 0, exc = 0;
			if(cap - w[idx] >= 0){
				inc = knapsack(n, v, w, cap - w[idx], idx) + v[idx];
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
				inc = knapsackMemo(n, v, w, cap - w[idx], idx, dp) + v[idx];
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
			// recursion
			// int ans = knapsack(n, val, wt, cap, 0);
			// System.out.println(ans);

			// memoization
			// int[][] dp = new int[n + 1][cap + 1];
			// int ans = knapsackMemo(n, val, wt, cap, 0, dp);
			// System.out.println(ans);

			// tabulation
			int[][] dp = new int[n + 1][cap + 1];
			for(int idx = n; idx >= 0; --idx){
				for(int c = 0; c <= cap; ++c){
					if(idx == n || c == 0){
						dp[idx][c] = 0;
						continue;
					}
			
					int inc = 0, exc = 0;
					if(c - wt[idx] >= 0){
						inc = dp[idx][c - wt[idx]] + val[idx];
					}
					exc = dp[idx + 1][c];
					dp[idx][c] = Math.max(inc, exc);
				}
			}

			System.out.println(dp[0][cap]);
	    }
	}
