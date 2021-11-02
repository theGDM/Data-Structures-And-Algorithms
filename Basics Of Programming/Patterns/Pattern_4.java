import java.util.*;

public class Pattern_4 {
  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        for (int i = 1; i <= n; ++i) {
            //to print spaces
            for (int j = 1; j <= (i - 1); ++j) {
                System.out.print("\t");
            }
            //to print stars
            for (int k = 1; k <= (n - i + 1); ++k) {
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
        scn.close();
    }
}
