import java.util.*;

public class power_linear {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int res = power(x,n); //expectation
        System.out.println(res);
        scn.close();
    }

    public static int power(int x, int n){
        if(n == 0) return 1; //base case x ^ 0 = 1
        int pxnm1 = power(x,n-1);//faith
        return pxnm1 * x; 
        //meeting expectation by multiplying the returned
        //power(x, n-1) by x
    }

}