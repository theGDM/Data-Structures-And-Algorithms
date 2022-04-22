import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] stc = new int[n];
        for(int i = 0;i < n; ++i){
            stc[i] = scn.nextInt();
        }


        //we consider every single day as a potential selling day
        //consider each point as selling point(think greedily)
        int minStkP = stc[0];
        int maxProfit = 0; //max profit
        for(int i = 0;i < stc.length; ++i){
            int currStkP = stc[i]; //current stock price
            int currProfit = 0; //currProfit
            
            if(currStkP < minStkP){
                minStkP = currStkP;
            }
            
            currProfit = currStkP - minStkP;
            if(currProfit > maxProfit){
                maxProfit = currProfit;
            }
        }
        System.out.println(maxProfit);
    }
    
}
