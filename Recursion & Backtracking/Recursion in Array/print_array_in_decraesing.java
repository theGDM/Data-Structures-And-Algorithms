import java.util.*;

public class print_array_in_decraesing{

    public static void main(String[] args) throws Exception {
        // write your code 
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; ++i){
            arr[i] = scn.nextInt();
        }
        
        displayArrReverse(arr, 0);
        scn.close();
    }

    public static void displayArrReverse(int[] arr, int idx) {
        //base case
        if(idx == arr.length){
            return;
        }
        
        //faith
        displayArrReverse(arr,idx + 1);
        
        //meeting expectation with faith
        System.out.println(arr[idx]);
    }

}