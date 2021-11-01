//Printing fibonacci series till number N
import java.util.*;

public class Fibonacci_Number_Till_N {
    public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int t1 = 0;
    int t2 = 1;
    int t3;
    for (int i = 1; i <= n; ++i) {
        System.out.println(t1);
        t3 = t1 + t2;
        t1 = t2;
        t2 = t3;
    }
    scn.close();
  }
}