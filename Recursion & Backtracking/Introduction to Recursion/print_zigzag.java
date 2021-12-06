import java.util.*;

public class print_zigzag {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    pzz(n);
    scn.close();
  }

  public static void pzz(int n) {
    if (n == 0) return; //base case
    
    //meeting expectation with faith
    System.out.print(n + " ");
    pzz(n - 1);//faith
    //meeting expectation with faith
    System.out.print(n + " ");
    pzz(n - 1);//faith
    //meeting expectation with faith
    System.out.print(n + " ");
  }

}