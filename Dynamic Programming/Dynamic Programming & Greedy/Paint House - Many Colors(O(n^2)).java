import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();
    
        int[][] cost = new int[n][c];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < c; ++j){
                cost[i][j] = scn.nextInt();
            }
        }

        //tabulation O(n2)
        int[][] dp = new int[cost.length][cost[0].length];

        int least = Integer.MAX_VALUE, sleast = Integer.MAX_VALUE;
        for(int j = 0; j < cost[0].length; ++j){
            dp[0][j] = cost[0][j];

            if(cost[0][j] <= least){
                sleast = least;
                least = cost[0][j];
            }else if(cost[0][j] <= sleast){
                sleast = cost[0][j];
            }
        }
        
        for(int i = 1; i < n; ++i){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;

            for(int j = 0; j < c; ++j){
                if(dp[i - 1][j] == least){
                    dp[i][j] = cost[i][j] + sleast;
                }else{
                    dp[i][j] = cost[i][j] + least;
                }

                if(dp[i][j] <= nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                }else if(dp[i][j] <= nsleast){
                    nsleast = dp[i][j];
                }
            }
           
            least = nleast;
            sleast = nsleast;
        }

        System.out.println(least);
    }
}
