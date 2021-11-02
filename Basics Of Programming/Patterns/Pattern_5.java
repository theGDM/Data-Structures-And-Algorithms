import java.util.*;

public class Pattern_5 {
  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        //upper-half
        int dec_counter=n/2;
        for (int i = 1; i <= (n / 2) + 1; ++i) {
            //for space
            for (int j = 1; j <= dec_counter; ++j) {
                System.out.print("\t");
            }
            //for stars
            for (int k = 1; k <= (2 * i - 1); ++k) {
                System.out.print("*" + "\t");
            }
            System.out.println();
            --dec_counter;
        }
        
        //lower_half
        int inc_counter=1;
        for (int i = (n / 2); i >= 1; --i) {
            //for space
            for (int j = 1; j <= inc_counter; ++j) {
                System.out.print("\t");
            }
            //for stars
            for (int k = 1; k <= (2 * i - 1); ++k) {
                System.out.print("*" + "\t");
            }
            System.out.println();
            ++inc_counter;
        }
       scn.close();    
    }
}