import java.util.*;

public class Print_Y {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //upper v shape
        for (int i = 1; i <= (n / 2) + 1; ++i) {
            //print space
            for (int j = 1; j <= i - 1; ++j) {
                System.out.print(" ");
            }
            //print 1 star
            System.out.print("*");
            //print space
            for (int j = 1; j <= (n - 1) - 2 * (i - 1); ++j) {
                System.out.print(" ");
            }
            //print 1 star
            if (i != (n / 2) + 1) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= (n / 2) - 1; ++i) {
            //space + 1 star
            for (int j = 1; j <= n / 2; ++j) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        scn.close();
    }
}
