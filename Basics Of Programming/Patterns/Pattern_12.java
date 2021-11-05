import java.util.*;

public class Pattern_12 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    // write ur code here
    int n = scn.nextInt();
    int t1 = 0;
    int t2 = 1;
    int t3;
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= i; ++j) {
        System.out.print(t1 + "\t");
        t3 = t1 + t2;
        t1 = t2;
        t2 = t3;
      }
      System.out.println();
    }
    scn.close();
  }
}