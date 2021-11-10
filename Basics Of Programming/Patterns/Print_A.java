import java.util.*;

public class Print_A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= n; ++i) {
            //decreasing space
            for (int j = 1; j <= n - i; ++j) {
                System.out.print(" ");
            }
            //one star
            System.out.print("*");
            //Odd no. of space
            for (int k = 1; k <= 2 * (i - 1) - 1 && i != 1; ++k){
                if (i == (n / 2) + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            //one star and new line
            if (i != 1) {
                System.out.print("*");
            }
            System.out.println();
        }
        scn.close();
    }
}