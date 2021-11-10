import java.util.*;

public class Multiple_Pyramid {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= 3; ++i) {
            //decreasing space linearly
            for (int j = 1; j <= 3 - i; ++j) {
                System.out.print(" ");
            }
            //stars
            for (int k = 1; k <= 2 * i - 1; ++k) {
                System.out.print("*");
            }
            for (int p = 1; p <= n - 1; ++p) {
                //decreasing space in a multiple of 2
                for (int l = 1; l <= 4 - 2 * (i - 1); ++l) {
                    System.out.print(" ");
                }
                //stars
                for (int k = 1; k <= 2 * i - 1; ++k) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        scn.close();
    }
}






