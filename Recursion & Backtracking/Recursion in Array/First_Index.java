import java.util.*;

public class First_Index {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0;i < n;++i){
            arr[i] = scn.nextInt();
        }
        
        int target = scn.nextInt();
        
        int index = firstIndex(arr, 0, target);
        System.out.println(index);
        scn.close();
    }

    public static int firstIndex(int[] arr, int idx, int x){
        //base case
        if(idx == arr.length) return -1;
        
        if(arr[idx] == x){
            return idx;//ME
        }else{
            return firstIndex(arr, idx + 1, x);//FAITH
        }
    }

}