import java.io.*;
import java.util.*;

public class Main{
  
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // tabulation
    // int[][] dp = new int[2][n + 1];
    // for(int i = n; i >= 0; --i){
    //     if(i == n){
    //         dp[0][i] = 1;
    //         dp[1][i] = 1;
    //         continue;
    //     }

    //     dp[0][i] = dp[1][i + 1];
    //     dp[1][i] = dp[0][i + 1] + dp[1][i + 1];
    // }
    // System.out.println(dp[1][0]);

    int[][] dp = new int[2][n];
    for (int i = n - 1; i >= 0; i--) {
      if (i == n - 1) {
          dp[0][i] = 1;
          dp[1][i] = 1;
          continue;
      }

      dp[0][i] = dp[1][i + 1];
      dp[1][i] = dp[0][i + 1] + dp[1][i + 1];
    }
    System.out.println(dp[0][0] + dp[1][0]);
  }
}
