import java.util.*;

public class print_array_in_increasing {

    public static void main(String[] args) throws Exception {
        // write your code 
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; ++i){
            arr[i] = scn.nextInt();
        }
        
        displayIncreasing(arr, 0);
        scn.close();
    }

    public static void displayIncreasing(int[] arr, int idx) {
        //base case
        if(idx == arr.length) return;
        
        //meeting expectation with faith
        System.out.println(arr[idx]);
        
        //faith
        displayIncreasing(arr,idx + 1);
    }

}