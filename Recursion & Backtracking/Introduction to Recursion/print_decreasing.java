import java.util.*;

public class print_decreasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n); //expectation
        scn.close();
    }

    public static void printDecreasing(int n){
        //base case
        if(n == 0) return;
        //1. Meeting expectation with faith
        System.out.println(n);
        //2. Faith
        printDecreasing(n - 1);
        
    }

}