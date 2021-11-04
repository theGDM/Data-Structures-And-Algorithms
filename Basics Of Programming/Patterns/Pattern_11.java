import java.util.*;

public class Pattern_11 {
   public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int count=0;
        for(int i=1;i<=n;++i){
            for(int j=1;j<=i;++j){
                ++count;
                System.out.print(count + "\t");
            }
            System.out.println();
        }
        scn.close();
    }
}
