import java.util.*;

public class GCD_And_LCM {
 public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);

    //taking input value in variables a, b, c
    int a = scn.nextInt();
    int b = scn.nextInt();

    if (a > b) {
      a = a + b;
      b = a - b;
      a = a - b;
    }

    int n1 = a;
    int n2 = b;

    //GCD (Euclidian method)
    int temp;
    while (a != 0) {
      temp = b % a;
      b = a;
      a = temp;
    }
    int gcd = b;
    System.out.println(gcd);

    //lcm (Basic method that we do on paper)
    int lcm = 1;
    int limit =n2;
    for (int i = 2; i <= limit; ++i) {
      while (n1 != 1 || n2 != 1) {
        if (n1 % i == 0 && n2 % i == 0) {
          lcm = lcm * i;
          n1 = n1 / i;
          n2 = n2 / i;
        } else if (n1 % i == 0) {
          lcm = lcm * i;
          n1 = n1 / i;
        } else if (n2 % i == 0) {
          lcm = lcm * i;
          n2 = n2 / i;
        } else {
            break;
        }
      }

    }
    System.out.println(lcm);
    //hcf (using formula: gcd * hcf = n1 * n2)
    //int lcm = (n1 * n2) / gcd;
    //System.out.println(lcm);
    scn.close();
  }
}