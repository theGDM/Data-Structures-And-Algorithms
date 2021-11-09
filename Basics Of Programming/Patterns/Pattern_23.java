import java.util.*;

public class Pattern_23 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= n; ++i) {
            int m = n;
            for (int j = 1; j <= n; ++j) {
                // System.out.print(m);
                for (int k = 1; k <= n - (i - 1); ++k) {
                    System.out.print(m);
                }
                --m;
            }
            System.out.println();      
        }
        scn.close();
    }
}
