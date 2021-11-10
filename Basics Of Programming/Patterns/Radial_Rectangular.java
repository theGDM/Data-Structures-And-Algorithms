import java.util.*;

public class Radial_Rectangular {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //upper half
        int row = 2*n-1;
        for (int i = 1; i <= row / 2 + 1; ++i) {
            int m = n;
            //Decreasing part
            for (int j = 1; j <= (i - 1); ++j) {
                System.out.print(m + "  ");
                --m;
            }
            //Constant part
            for (int k = 1; k <= row - 2 * (i - 1); ++k) {
                System.out.print(m + "  "); 
            }
            //Decresing part
            m = m + 1;
            for (int l = 1; l <= (i - 1); ++l) {
                System.out.print(m + "  ");
                ++m;
            }
            System.out.println();
        }
        //upper half
        for (int i = 1; i <= row / 2; ++i) {
            int m = n;
            //Decreasing part
            for (int j = 1; j <= (row/2)-i; ++j) {
                System.out.print(m + "  ");
                --m;
            }
            //Constant part
            for (int k = 1; k <= 2 * (i + 1) - 1; ++k) {
                System.out.print(m + "  ");
            }
            //Decresing part
            m = m + 1;
            for (int l = 1; l <= (row/2)-i; ++l) {
                System.out.print(m + "  ");
                ++m;
            }
            System.out.println();
        }
        scn.close();
    }
}