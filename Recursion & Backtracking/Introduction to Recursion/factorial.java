import java.util.*;

public class factorial {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int res = factn(n);
        System.out.println(res);
        scn.close();
    }

    public static int factn(int n){
        if(n == 0) return 1;
        //Faith
        int factnm1 = factn(n - 1);
        //Meeting expectation with faith
        return factnm1 * n;
    }

}
