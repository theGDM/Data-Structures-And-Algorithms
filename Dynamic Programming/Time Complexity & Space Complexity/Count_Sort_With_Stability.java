import java.util.*;

public class Count_Sort_With_Stability {

    public static void countSort(int[] arr, int min, int max) {
        // write your code here
        // count sort with stability
        // traversal-2 (making frequency array)
        int[] frequency = new int[max - min + 1];
        for (int i = 0; i < arr.length; ++i) {
            int idx = arr[i] - min;
            ++frequency[idx];
        }

        // traversal-3 (making prefix sum array)
        int[] prefSum = new int[frequency.length];
        prefSum[0] = frequency[0];
        for (int i = 1; i < frequency.length; ++i) {
            prefSum[i] = prefSum[i - 1] + frequency[i];
        }

        // traversal-4 (traverse arr from right to left)
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            --prefSum[arr[i] - min];
            int idx = prefSum[arr[i] - min];
            res[idx] = arr[i];
        }

        // traversal-5 (fill the original array by res array)
        for (int i = 0; i < res.length; ++i) {
            arr[i] = res[i];
        }
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
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
        scn.close();
    }

}