import java.util.*;

public class Subarray_Problem {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    //size of array
    int n = scn.nextInt();

    //declaration and initialization of array
    int[] arr = new int[n];

    //taking inputs in array
    for (int i = 0; i < n; ++i) {
      arr[i] = scn.nextInt();
    }

    //printing subarrays
    for (int st = 0; st < n; ++st) { //starting index
        for (int en = st; en < n; ++en) { //ending index
            for (int k = st; k <= en; ++k) { //starting index to ending index
                System.out.print(arr[k] + "\t");
            }
            System.out.println();
        }
    }
    scn.close();
  }

}
