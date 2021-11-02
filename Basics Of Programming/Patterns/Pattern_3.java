import java.util.*;

public class Pattern_3 {
  public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        for(int i=1;i<=n;++i){
            //to print spaces
            for(int j=1;j<=(n-i);++j){
                System.out.print("\t");
            }
            //to print stars
            for(int k=1;k<=i;++k){
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
        scn.close();
    }
}