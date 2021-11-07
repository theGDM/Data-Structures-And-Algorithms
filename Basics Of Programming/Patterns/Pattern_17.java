import java.util.*;

public class Pattern_17 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        //upper-half
        for(int i=1;i<=(n/2)+1;++i){
            for(int j=1;j<=(n/2);++j){
                if(i != (n/2)+1){
                    System.out.print("\t");
                }else{
                    System.out.print("*" + "\t");
                }
            }
            for(int k=1;k<=i;++k){
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
        
        //lower-half
        for(int i=1;i<=(n/2)+1;++i){
            for(int j=1;j<=(n/2);++j){
                System.out.print("\t");
            }
            for(int k=1;k<=(n/2)-(i-1);++k){
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
        scn.close();
    }
}