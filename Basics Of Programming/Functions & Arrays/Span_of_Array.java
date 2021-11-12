import java.util.*;

public class Span_of_Array{
  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    //declaring and initializing array
    int[] arr = new int[n];
    //taking inputs
    for(int i=0;i<n;++i){
        arr[i] = scn.nextInt();
    }
    
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    
    //traversing array
    for(int i=0;i<n;++i){
        //is current element greater than max
        if(arr[i] > max){
            max = arr[i];
        }
        //is current element less than min
        if(arr[i] < min){
            min = arr[i];
        }
    }
    System.out.println(max - min);
    scn.close();
 }

}