//Rotate a number based on a value of k
import java.util.*;
   
   public class Rotate_A_Number{
   public static void main(String[] args) {
     // write your code here 
     Scanner scn = new Scanner(System.in);
     int n=scn.nextInt();
     int k=scn.nextInt();
     
     //part-1 | count the digit of number
     int temp=n;
     int size=0;
     while(temp!=0){
         ++size;
         temp=temp/10;
     }
     
     //part-2 | checking k is +ve or -ve
     k=k%size;
     if(k<0){
         k=k+size;
     }
     
     //part-3 | making div = div * 10^k and mul = mul * 10^(size-k)
     int div=1;
     int mul=1;
     for(int i=1;i<=size;++i){
         if(i<=k){
             div=div*10;
         }else{
             mul=mul*10;
         }
     }
     
     //part-4 | making rotate
     int rem = n%div;
     int num = n/div;
     int rotate = rem*mul + num;
     
     System.out.println(rotate);
     scn.close();
    }
}
