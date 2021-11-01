//inverse of a number from Right to Left, by replacing face value with place value
import java.util.*;

public class Inverse_Of_A_Number {
    public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int size = 0;
    int temp = n;

    //size of a number
    while (temp != 0) {
      ++size;
      temp = temp / 10;
    }

    int pv = 1;
    int fv;
    int ipv;
    int ifv = 0;
    int inverse = 0;
    while (pv <= size) {
      fv = n % 10;
      ifv = pv;
      ipv = fv;
      int i = 1;
      while (i < ipv) {
        ifv = ifv * 10;
        ++i;
      }
      inverse = inverse + ifv;
      n = n / 10;
      ++pv;
    }
    System.out.println(inverse);
    scn.close();
  }
}