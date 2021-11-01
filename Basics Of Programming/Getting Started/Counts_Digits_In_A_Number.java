//Counting total digits in a number
import java.util.*;
  
  public class Counts_Digits_In_A_Number{
  public static void main(String[] args) {
    // write your code here  
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int size = 0;
    while(n!=0){
        ++size;
        n/=10;
    }
    System.out.println(size);
    scn.close();
   }
  }