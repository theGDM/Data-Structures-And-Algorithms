import java.util.*;

public class Inverted_Bar_Chart {

  public static int getMax(int[] a) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);

    //size of array
    int n = scn.nextInt();
    
    //array declaration and initialisation
    int[] arr = new int[n];

    //getting element in array
    for (int i = 0; i < n; ++i) {
      arr[i] = scn.nextInt();
    }

    //maximum element
    int max = getMax(arr);

    //printing inverted bar graph
    for (int i = 1; i <= max; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i <= arr[j]) {
                System.out.print("*" + "\t");
            } else {
                System.out.print("\t");
            }
        }
        System.out.println();
    }
    scn.close();
  }

}