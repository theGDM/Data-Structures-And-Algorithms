import java.util.*;

public class power_logarothmic {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int res = power(x, n); //expectation
        System.out.println(res);
        scn.close();
    }

    public static int power(int x, int n){
        if(n == 0) return 1;//faith case
        int pxnby2 = power(x, n/2); //faith
        if(n % 2 == 1){
            return pxnby2 * pxnby2 * x; //meeting exexpectation if n is odd
        }else{
            return pxnby2 * pxnby2; //meeting exexpectation if n is even
        }
    }

}