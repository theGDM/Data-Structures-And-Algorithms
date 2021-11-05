import java.util.*;

public class Pattern_13_Function {

  //Using function
  public static int ncr(int n) {
    int res = 1;
    if (n == 0 || n < 0) {
      return 1;
    } else {
      for (int i = 1; i <= n; ++i) {
        res = res * i;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    //write your code here
    int res;
    int n = scn.nextInt();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j <= i; ++j) {
           res = ncr(i) / (ncr(j) * ncr(i - j));
           System.out.print(res + "\t");
        }
      System.out.println();
    }
    scn.close();
  }
}
