import java.util.*;

public class max_of_an_array {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; ++i) {
      arr[i] = scn.nextInt();
    }

    int res = maxOfArray(arr, 0);
    System.out.println(res);
    scn.close();
  }

  public static int maxOfArray(int[] arr, int idx) {
    //base case
    if(idx == arr.length) return Integer.MIN_VALUE;
    
    //faith
    int tempMax = maxOfArray(arr, idx + 1);
    
    //meeting expectation with faith
    return Math.max(tempMax, arr[idx]);
  }

}