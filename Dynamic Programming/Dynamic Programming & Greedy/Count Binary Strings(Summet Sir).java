import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    // int[] dp0 = new int[n + 1];
    // int[] dp1 = new int[n + 1];

    // dp0[1] = 1; //binary string of length 1, ending with 0s, "0"
    // dp1[1] = 1; //binary string of length 1, ending with 1s, "1"

    // for(int i = 2; i <= n; ++i){
    //   dp0[i] = dp1[i - 1];
    //   dp1[i] = dp1[i - 1] + dp0[i - 1]; //pichli bar ke 0 ke peeche 1 aur pichli bar ke 1 ke peeche 1
    // }

    // int ans = dp0[n] + dp1[n]; //binary string of length n, that satisfy the conditions
    // System.out.println(ans);

    // 2nd way O(1) space
    int oczeroes = 1;
    int ocones = 1;

    for(int i = 2; i <= n; ++i){
      int nczeroes = ocones;
      int ncones = ocones + oczeroes;

      oczeroes = nczeroes;
      ocones = ncones;
    }

    System.out.println(ocones + oczeroes);
 }
}
