import java.util.*;

public class Broken_Economy_Bruteforce {

  public static int findExactDenomination(int[] a, int e) {
    for (int i = 0; i < a.length; ++i) {
      if (a[i] == e) {
        return i;
      }
    }
    return -1;
  }

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

    //asked denomiantion number
    int d = scn.nextInt();

    //find exact availble denomination number, if not find interval
    int res = findExactDenomination(arr, d);
    
    if (res != -1) {
      System.out.println(arr[res]);
    } else {
      for (int i = 0; i < n-1; ++i) {
        if (d > arr[i] && d < arr[i + 1]) {
            System.out.println(arr[i + 1]);
            System.out.println(arr[i]);
            break;
        }
      }
    }
    scn.close();
  }

}