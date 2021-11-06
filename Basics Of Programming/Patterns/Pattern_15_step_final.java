import java.util.*;

public class Pattern_15_step_final {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        int an = 0;
        //upper-half
        for(int i=1;i<=(n/2)+1;++i){
            //for space
            for(int j=1;j<=(n/2)+1-i;++j){
                System.out.print("\t");
            }
            //for stars
            for(int k=1;k<=2*i-1;++k){
                if(k>((2*i-1)/2 + 1)){
                    an = an-1;
                    System.out.print(an + "\t");
                }else{
                    an = i + (k-1);
                    System.out.print(an + "\t");
                }
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
                if(k>((n-2*i)/2 + 1)){
                    an = an-1;
                    System.out.print(an + "\t");
                }else{
                    an = (n/2)-(i-1)+(k-1);
                    System.out.print(an + "\t");
                }
            }
            System.out.println();
        }
        scn.close();
    }
}