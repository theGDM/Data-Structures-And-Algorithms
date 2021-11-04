import java.util.*;

public class Pattern_10{
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
        //upper-half
        for(int i=1;i<=(n/2)+1;++i){
            for(int j=1;j<=(n/2)+1-i;++j){
                System.out.print("\t");
            }
            for(int k=1;k<=1;++k){
                System.out.print("*" + "\t");
            }
            for(int l=1;l<=2*(i-1)-1 && i!=1;++l){
                System.out.print("\t");
            }
            for(int m=1;m<=1 && i!=1;++m){
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
        
        
        //lower-half
        for(int i=1;i<=(n/2);++i){
            for(int j=1;j<=i;++j){
                System.out.print("\t");
            }
            for(int k=1;k<=1;++k){
                System.out.print("*" + "\t");
            }
            for(int l=1;l<=n-2*(i+1);++l){
                System.out.print("\t");
            }
            for(int m=1;m<=1 && i!=(n/2);++m){
                System.out.print("*" + "\t");
            }
            System.out.println();
        }
        scn.close();   
    }
}

