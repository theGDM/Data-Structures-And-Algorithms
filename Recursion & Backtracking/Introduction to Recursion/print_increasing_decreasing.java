import java.util.*;

public class print_increasing_decreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pdi(n);
        scn.close();
    }

    public static void pdi(int n){
        if(n == 0) return;
        //Meeting expectation with faith - 1
        System.out.println(n);
        //Faith
        pdi(n - 1);
        //Meeting expectation with faith - 2
        System.out.println(n);
        
    }

}