import java.util.*;
  
public class Decimal_to_Any_Base_Function{
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
      scn.close();
   }
  
   public static int getValueInBase(int n, int b){
       // write code here
       int res = 0;
       int i = 0;
       while(n>0){
           int rem = n%b; //remainder
           n = n/b; //quotient
           res = res + rem * (int)Math.pow(10,i);
           ++i;
       }
       return res;
   }
}