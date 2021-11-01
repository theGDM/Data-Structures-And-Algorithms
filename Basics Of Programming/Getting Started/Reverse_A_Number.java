//Printing digits of no from right to left
import java.util.*;

public class Reverse_A_Number {
    public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int r;
    while (n != 0) {
        r = n % 10;
        n = n / 10;
        System.out.println(r);
    }
    scn.close();
  }
}