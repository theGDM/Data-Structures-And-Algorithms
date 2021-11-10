import java.util.*;
public class Inverted_Heart {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //upper part
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n - i; ++j) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; ++k) {
                System.out.print("*");
            }
            System.out.println();
        }
        //lower part
        for (int i = 1; i <= (n/4)+1; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(" ");
            }
            for (int k = 1; k <=n - 2 * i; ++k) {
                System.out.print("*");
            }
            for (int l = 1; l <= 2 * i - 1; ++l) {
                System.out.print(" ");
            }
            for (int m = 1; m <=n - 2 * i; ++m) {
                System.out.print("*");
            }
            System.out.println();
        }

        scn.close();
    }
}
