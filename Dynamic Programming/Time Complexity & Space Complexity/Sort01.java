import java.util.*;

public class Sort01 {

    public static void sort01(int[] arr) {
        // write your code here
        int left = 0;
        int right = 0;
        // unexplored region -> right to arr.length
        // 1's -> left to right - 1
        // 0's -> 0 t0 left - 1
        while (right < arr.length) {
            if (arr[right] == 1) {
                ++right;
            } else {
                swap(arr, right, left);
                ++left;
                ++right;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort01(arr);
        print(arr);
        scn.close();
    }

}