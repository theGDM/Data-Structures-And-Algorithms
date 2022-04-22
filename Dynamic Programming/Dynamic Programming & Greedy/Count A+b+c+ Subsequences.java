import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        // simple iteratve approach
        // int a = 0; //count of pattern ending with a
        // int ab = 0; //count of pattern ending with b
        // int abc = 0; //count of pattern ending with c
        // for(int i = 0; i < str.length(); ++i){
        //     char ch = str.charAt(i);
        //     if(ch == 'a'){
        //         a = 2 * a + 1; //a me a' lag kar aaye ya na aaye + 1(ya a' akel aaye)
        //     }else if(ch == 'b'){
        //         ab = 2 * ab + a; //ab me b' lag kar aaye ya na aaye + a ke end me b' lag kar aaye 
        //     }else if(ch == 'c'){ 
        //         abc = 2 * abc + ab; //abc me c' lag kar aaye ya na aaye + ab ke end me c' lag kar aaye
        //     }
        // }

        // System.out.println(abc);

        // tabulation
        int[][] dp = new int[3][str.length() + 1];
        for(int i = 0; i < dp[0].length; ++i){
            if(i == 0){
                continue;
            }
            
            char ch = str.charAt(i - 1);

            if(ch == 'a'){
                dp[0][i] = 2 * dp[0][i - 1] + 1;
                dp[1][i] = dp[1][i - 1];
                dp[2][i] = dp[2][i - 1];
            }else if(ch == 'b'){
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = 2 * dp[1][i - 1] + dp[0][i];
                dp[2][i] = dp[2][i - 1];
            }else if(ch == 'c'){
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[1][i - 1];
                dp[2][i] = 2 * dp[2][i - 1] + dp[1][i];
            }
        }

        for(int i = 0;i < dp.length; ++i){
            for(int j = 0;j < dp[0].length; ++j){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(dp[2][dp[0].length - 1]);
    }
}
