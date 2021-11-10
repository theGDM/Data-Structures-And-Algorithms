import java.util.*;
  
  public class Any_Base_to_decimal{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
      scn.close();
   }
  
   public static int getValueIndecimal(int n, int b){
      // write your code here
      //destination base is fixed here,i.e 10
      //source base is variable here,i.e is b
      int res=0;
      int mul=1;
      while(n>0){
          int rem = n % 10; //remainder
          int divisor = n / 10; //divisor
          n = divisor; //change value of n
          res = res + rem * mul; //update result
          mul*=b;//change mul
      }
      return res;
   }
 }