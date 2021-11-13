import java.util.*;

public class Bar_Chart{

 public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    //getting size of array
    int n = scn.nextInt();
    
    // array declaration and initialization
    int[] arr = new int[n];
    
    // getting elements in array
    for(int i = 0;i<n;++i){
        arr[i] = scn.nextInt();
    }
    
    //getting max entry
    int max = Integer.MIN_VALUE;
    for(int i = 0;i<n;++i){
        if(arr[i]>max){
          max = arr[i];  
        }
    }
    
    //bar graph
    for(int i = 1;i<=max;++i){ //no of rows for bar chart
        for (int j = 0; j < n; ++j) { //inner loop runs till size of array
            if (i <= max - arr[j]) {
                System.out.print("\t");
            } else {
                System.out.print("*" + "\t");
            }
        }
        System.out.println();
    }
    scn.close();
 }

}