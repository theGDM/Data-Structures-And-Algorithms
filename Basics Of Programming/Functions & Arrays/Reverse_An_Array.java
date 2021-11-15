import java.io.*;

public class Reverse_An_Array {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void swap(int[] arr, int l, int r) {
    int temp;
    temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }

  public static void reverse(int[] a) {
    // write your code here
    int left = 0;
    int right = a.length - 1;

    while (left < right) {
      swap(a, left, right);
      ++left;
      --right;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    reverse(a);
    display(a);
  }

}
