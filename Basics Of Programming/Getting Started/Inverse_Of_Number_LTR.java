//Print inverse of a number from left to right, by replacing face value with place value
import java.util.*;

public class Inverse_Of_Number_LTR {
 public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    //part-1
    int temp = n;
    int count = 0;
    while (temp != 0) {
      ++count;
      temp = temp / 10;
    }

    //part-2
    int div = 1;
    for (int i = 1; i <= (count - 1); ++i) {
      div = div * 10;
    }

    //part-3
    int pv = 1;
    int fv;
    int ifv;
    int ipv;
    int inverse = 0;
    while (pv <= count) {
      fv = n / div;
      ipv = (count + 1) - fv;
      ifv = pv;
      int j = 1;
      while (j < ipv) {
        ifv = ifv * 10;
        ++j;
      }
      inverse = inverse + ifv;
      n = n % div;
      div = div / 10;
      ++pv;
    }
    System.out.println(inverse);
    scn.close();
  }
}