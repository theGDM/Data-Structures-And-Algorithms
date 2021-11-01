//Printing digits of a number from left to right using Math.pow() function 
import java.util.*;

public class Digits_of_Number_With_Power_func {
  public static void main(String[] args) {

    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int size = 0;
    int temp = n;
    int r;

    //part-1 | count digits of a number
    while (temp != 0) {
      ++size;
      temp /= 10;
    }

    //part 2 | printing digits of a number
    for (int i = size - 1; i >= 0; --i) {
      r = n / (int) Math.pow(10, i);
      n = n % (int) Math.pow(10, i);
      System.out.println(r);
    }
    scn.close();
  }
}