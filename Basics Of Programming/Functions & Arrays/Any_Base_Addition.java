import java.util.*;

public class Any_Base_Addition {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getSum(b, n1, n2);
    System.out.println(d);
    scn.close();
  }

  public static int getSum(int b, int n1, int n2) {
    // write ur code here
    int res = 0;
    int mul = 1;
    int rem = 0;
    int carry = 0;
    while (n1 != 0 || n2 != 0 || carry != 0) {
      int rn1 = n1 % 10; //extracting rem of n1
      int rn2 = n2 % 10; //extracting rem of n2
      rem = (carry + rn1 + rn2) % b; //rem
      carry = (carry + rn1 + rn2) / b; //carry
      res = res + rem * mul; //running result sum
      mul *= 10; //updating mul
      n1 = n1 / 10; //reducing n1 by 10
      n2 = n2 / 10; //reducing n2 by 10
    }
    return res;
  }
}
