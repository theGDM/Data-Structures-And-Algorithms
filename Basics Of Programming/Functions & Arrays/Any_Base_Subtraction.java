import java.util.*;

public class Any_Base_Subtraction {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getDifference(b, n1, n2);
    System.out.println(d);
    scn.close();
  }

  public static int getDifference(int b, int n1, int n2) {
    // write your code here
    int res = 0;
    int borrow = 0;
    int sub;
    int mul = 1;
    while (n1 != 0 || n2 != 0 || borrow != 0) {
      int rn1 = n1 % 10;
      int rn2 = n2 % 10;
      if ((borrow + rn2) >= rn1) {
        sub = (borrow + rn2) - rn1;
        borrow = 0;
      } else {
        sub = (borrow + rn2 + b) - rn1;
        borrow = -1;
      }
      res = res + sub * mul;
      mul *= 10;
      n1 /= 10;
      n2 /= 10;
    }
    return res;
  }

}