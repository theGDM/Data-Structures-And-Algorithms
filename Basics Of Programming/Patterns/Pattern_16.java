import java.util.*;

public class Pattern_16{

    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n = scn.nextInt();
     for(int i=1;i<=n;++i){
         //print number in increasing order
         for(int j=1;j<=i;++j){
             System.out.print(j + "\t");
         }
         //print odd number of space
         for(int k=1;k<=((2*n-1) - 2*i);++k){
             System.out.print("\t");
         }
         //print numbers in decreasing order
         int val = i!=n ? i : i-1 ;
         int limit = val;
         for(int k=1;k<=limit;++k){
             System.out.print(val + "\t");
             --val;
         }
         System.out.println();
     }
     scn.close();
 }
}