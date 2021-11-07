import java.util.*;

public class Pattern_18{

    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n = scn.nextInt();
     
     //upper-hollow part
     for(int i=1;i<=(n/2)+1;++i){
         for(int j=1;j<=n;++j){
             if(i==1 || i==j || (i+j)==(n+1)){
                 System.out.print("*" + "\t");
             }else{
                 System.out.print("\t");
             }
         }
         System.out.println();
     }
     
    //lower-part
    for(int i=1;i<=(n/2);++i){
        for(int j=1;j<=(n/2)-i;++j){
            System.out.print("\t");
        }
        for(int k=1;k<=2*(i+1)-1;++k){
            System.out.print("*" + "\t");
        }
        System.out.println();
    }
    scn.close();
 }
}