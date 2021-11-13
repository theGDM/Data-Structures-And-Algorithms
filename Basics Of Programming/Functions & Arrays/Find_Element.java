import java.util.*;

public class Find_Element {

  public static int linearSearch(int[] a, int e) {
    //traversing array to find the index of element d
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
    int n = scn.nextInt();

    //declartion and initialization of arr
    int[] arr = new int[n];

    //reding values in array
    for (int i = 0; i < n; ++i) {
      arr[i] = scn.nextInt();
    }

    int d = scn.nextInt();

    System.out.println(linearSearch(arr, d));
    scn.close();
  }

}