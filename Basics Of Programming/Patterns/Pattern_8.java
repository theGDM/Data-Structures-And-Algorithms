import java.util.*;

public class Pattern_8 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        for(int i=1;i<=n;++i){
            //to print space
            for(int j=1;j<=n-i;++j){
                System.out.print("\t");
            }
            //to print * and hit enter
            System.out.println("*");
        }
        scn.close();
    }
}
