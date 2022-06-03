import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    //arr1
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i = 0;i < n1; ++i){
        arr1[i] = scn.nextInt();
    }

    //arr2
    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i = 0;i < n2; ++i){
        arr2[i] = scn.nextInt();
    }

    //creating Hashmap for arr1 (number, count)
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int val : arr1){
        if(hm.containsKey(val)){
            hm.put(val, hm.get(val) + 1);
        }else{
            hm.put(val, 1);
        }
    }
    
    //making frequency array for arr2
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < arr2.length; ++i){
        max = Math.max(max, arr2[i]);
    }

    int[] freq = new int[max + 1];
    for(int i = 0;i < arr2.length; ++i){
        ++freq[arr2[i]];
    }

    for(int val : arr2){
        if(freq[val] > 0){
            if(hm.containsKey(val)){
                System.out.println(val);
            }
            freq[val] = 0; //make count to zero, so that if it appears again, we dont't check
        }
    }
 }
}
