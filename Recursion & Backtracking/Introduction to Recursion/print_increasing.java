import java.util.*;

public class print_increasing {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printIncreasing(n); //expectation
        scn.close();
    }

    public static void printIncreasing(int n){
        //Base case
        if(n == 0) return;
        //1. Faith
        printIncreasing(n - 1);
        //2. Meeting expectation with faith
        System.out.println(n);
    }

}