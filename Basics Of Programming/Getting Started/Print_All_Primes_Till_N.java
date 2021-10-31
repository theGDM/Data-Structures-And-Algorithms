import java.util.*;

public class Print_All_Primes_Till_N {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    // write ur code here
    int low = scn.nextInt();
    int high = scn.nextInt();
    int flag;
    for (int i = low; i <= high; ++i) {
        flag = 1;
        for (int j = 2; j * j <= i; ++j) {
            if (i % j == 0) { 
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            System.out.println(i);
        }
    }
    scn.close();
  }
}
