import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i){
            arr[i] = scn.nextInt();
        } 
        int tar = scn.nextInt(); //given target
        
        // recursion
        // boolean ans = targetSum(0, n, tar, arr);
        // System.out.println(ans);

        // memoization
        boolean[][] dp = new boolean[n + 1][tar + 1];
        boolean ans = memo(0, n, tar, arr, dp);
        System.out.println(ans);
    }

    public static boolean memo(int idx, int n, int target, int[] arr, boolean[][] dp){
        if(idx == n){
            if(target == 0){
                return dp[idx][target] = true;
            }else{
                return dp[idx][target] = false;
            }
        }

        if(dp[idx][target] != false){
            return dp[idx][target];
        }

        boolean ans = false;
        if(target - arr[idx] >= 0){
            ans = memo(idx + 1, n, target - arr[idx], arr, dp);
            if(ans == true){
                return dp[idx][target] = true;
            }
        }
        ans = memo(idx + 1, n, target, arr, dp);

        return dp[idx][target] = ans;
    }

    public static boolean targetSum(int idx, int n, int target, int[] arr){
        if(idx == n){
            if(target == 0){
                return true;
            }else{
                return false;
            }
        }

        boolean ans = false;
        if(target - arr[idx] >= 0){
            ans = targetSum(idx + 1, n, target - arr[idx], arr);
            if(ans == true){
                return true;
            }
        }
        ans = targetSum(idx + 1, n, target, arr);

        return ans;
    }


}
