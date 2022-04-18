import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //O(n) approach
    // int[][] dp = new int[2][n];
    // for(int i = n - 1; i >= 0; --i){
    //     if(i == n - 1){
    //         dp[0][i] = 1;
    //         dp[1][i] = 1;
    //         continue;
    //     }

    //     dp[0][i] = dp[1][i + 1];
    //     dp[1][i] = dp[0][i + 1] + dp[1][i + 1];
    // }
    // long m = dp[0][0] + dp[1][0];
    // System.out.println(m * m);

    //space optimization O(1)
    long space = 1;
    long building = 1;
    for(int i = 2;i <= n; ++i){
        //if adding space, BS', SS'
        long ns = space + building;
        //if adding building, SB'
        long nb = space;
        space = ns;
        building = nb;
    }

    long ans = (space + building) * (space + building);
    System.out.println(ans);
 }

}
