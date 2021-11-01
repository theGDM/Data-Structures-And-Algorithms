//Printing digits of a number from left to right without using Math.pow() function 
import java.util.*;

public class Digits_of_Number_Without_Power_func {
  public static void main(String[] args) {

    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int size = 0;
    int temp = n;
    int r;
    int div = 1;

    //part-1 | count digits of a number
    while (temp != 0) {
      ++size;
      temp /= 10;
    }


    //part -2 | making div * 10^(size-1)
    for (int i = 1; i < size; ++i) {
      div *= 10;
    }

    //part 3 | printing digits of a number
    while (div != 0) {
      r = n / div;
      n = n % div;
      div /= 10;
      System.out.println(r);
    }
    scn.close();
  }

}