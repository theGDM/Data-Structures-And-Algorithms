import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for(int i = 0;i < n; ++i){
            prices[i] = scn.nextInt();
        }
        //if there is not dip we keep increasing sp, but when we got first dip
        //then we first update the op and then move sp and bp together till the
        //increse in price

        int bp = prices[0];
        int sp = prices[0];
        int op = 0;

        boolean firstDip = true;
        for(int i = 1;i < prices.length; ++i){
            if(prices[i] >= prices[i - 1]){
                sp = prices[i];
            }else if(prices[i] < prices[i - 1]){
                op += sp - bp;
                sp = prices[i];
                bp = prices[i];
            }
        }
        op += sp - bp; //for last transaction
        System.out.println(op);
    }
    
}
