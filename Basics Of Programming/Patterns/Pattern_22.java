import java.util.*;

public class Pattern_22 {

    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    // write ur code here
    int n = scn.nextInt();
    
    //upper solid inverted pyramid
    for(int i=1;i<=(n/2)+1;++i){
        //spaces one less than row value
        for(int j=1;j<=(i-1);++j){
            System.out.print("\t");
        }
        //odd number of stars
        for(int k=1;k<=n-2*(i-1);++k){
            System.out.print("*" + "\t");
        }
        System.out.println();
    }
    
    //lower hollow pyramid
    for(int i=1;i<=(n/2);++i){
        for(int j=1;j<=n;++j){
            if(i==(j-(n/2+1)) || (i+j)==(n/2+1) || i==(n/2)){
                System.out.print("*" + "\t");
            }else{
                System.out.print("\t");
            }
        }
        System.out.println();
    }
    scn.close();
  }
}