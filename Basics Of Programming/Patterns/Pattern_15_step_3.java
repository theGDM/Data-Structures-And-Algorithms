import java.util.*;

public class Pattern_15_step_3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        //upper-half
        for(int i=1;i<=(n/2)+1;++i){
            //for space
            for(int j=1;j<=(n/2)+1-i;++j){
                System.out.print("\t");
            }
            //for stars
            for(int k=1;k<=2*i-1;++k){
                System.out.print(i+(k-1) + "\t");
            }
            System.out.println();
        }
        
        //lower-half
        for(int i=1;i<=(n/2);++i){
            //for space
            for(int j=1;j<=i;++j){
                System.out.print("\t");
            }
            //for stars
            for(int k=1;k<=n-2*i;++k){
                System.out.print((n/2)+1-i+(k-1) + "\t");
            }
            System.out.println();
        }
        scn.close();
    }
}