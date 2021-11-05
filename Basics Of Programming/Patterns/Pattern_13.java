import java.util.*;

public class Pattern_13 {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    //write your code here
    int n = scn.nextInt();
    int icj;
    int icjp1;
    for (int i = 0; i < n; ++i) {
      icj = 1;
      for (int j = 0; j <= i; ++j) {
        System.out.print(icj + "\t");
        icjp1 = (icj * (i - j)) / (j + 1);
        icj = icjp1;
      }
      System.out.println();
    }
    scn.close();
  }
}