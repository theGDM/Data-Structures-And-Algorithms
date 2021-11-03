import java.util.*;

public class Pattern_6 {
    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    // write ur code here
    int n = scn.nextInt();
    //upper-part
    for(int i=1; i<=(n/2)+1;++i){
        for(int j=1;j<=((n/2)+2-i);++j){
            System.out.print("*"+"\t");
        }
        for(int k=1;k<=(2*i-1);++k){
            System.out.print("\t");
        }
        for(int l=1;l<=((n/2)+2-i);++l){
            System.out.print("*"+"\t");
        }
        System.out.println();
    }
    //lower-part
    for (int i = 1; i <= (n / 2); ++i) {
        for (int j = 1; j <= i + 1; ++j) {
            System.out.print("*" + "\t");
        }
        for (int k = 1; k <= (n - 2 * i); ++k) {
            System.out.print("\t");
        }
        for (int l = 1; l <= i + 1; ++l) {
            System.out.print("*" + "\t");
        }
        System.out.println();
    }
    scn.close();
  }
}