import java.util.*;

public class Last_Index {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0;i < n;++i){
            arr[i] = scn.nextInt();
        }
        
        int target = scn.nextInt();
        
        int index = lastIndex(arr, arr.length - 1, target);
        System.out.println(index);
        scn.close();
    }

    public static int lastIndex(int[] arr, int idx, int x){
        //base case
        if(idx == arr.length) return -1;
        
        if(arr[idx] == x){
            return idx;//me
        }else{
            return lastIndex(arr, idx - 1, x);//faith
        }
    }

}