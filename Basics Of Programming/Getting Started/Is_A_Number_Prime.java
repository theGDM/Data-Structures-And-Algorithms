import java.util.*;
  
  public class Is_A_Number_Prime{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       int t=scn.nextInt();
       int i =1;
       int flag;
       while(i<=t){
           int n=scn.nextInt();
           flag=1;
           for(int j=2;j*j<=n;++j){
               if(n%j==0){
                   flag=0;
                   break;
               }
           }
           if(flag==1){
               System.out.println("prime");
           }else{
               System.out.println("not prime");
           }
           ++i;
       }
       scn.close();
   }
  }
