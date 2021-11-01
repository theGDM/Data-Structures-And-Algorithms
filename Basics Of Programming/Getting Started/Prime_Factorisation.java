//Prime factorisation of a number more optimized
import java.util.*;

public class Prime_Factorisation {
 public static void main(String[] args) {
  // write your code here  
  Scanner scn = new Scanner(System.in);
  int n=scn.nextInt();
  int temp=n;
  for (int i = 2; i <= temp && n != 1; ++i) {
      while (n % i == 0) {
          System.out.print(i + " ");
          n = n / i;
      }
  }
  scn.close();
 }
}