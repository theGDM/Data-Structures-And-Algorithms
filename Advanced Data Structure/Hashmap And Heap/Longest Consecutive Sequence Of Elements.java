import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner (System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0;i < n; ++i){
        arr[i] = scn.nextInt();
    }

    HashMap<Integer, Boolean> hm = new HashMap<>();
    //make all the elements as starting point
    for(int val : arr){
        if(!hm.containsKey(val)){
            hm.put(val, true);
        }
    }
    
    //make only those elements true which are starting point
    for(int val : arr){
        if(hm.containsKey(val - 1)){
            hm.put(val, false);
        }
    }

    int msp = 0;
    int ml = 0;
    for(int val : arr){
        if(hm.get(val)){
            int tl = 1; //temp length of consecutive sequence of elements
            int tsp = val; //temp starting point of consecutive sequence of elements
            
            //keep counting till we get tsp + t1
            while(hm.containsKey(tsp + tl)){
                ++tl;
            }

            if(tl > ml){
                msp = tsp;
                ml = tl;
            }
        }
    }
    
    for(int i = 0; i < ml; ++i){
        System.out.println(i + msp);
    }
 }
}
