import java.util.*;

public class Count_Sort {

    public static void countSort(int[] arr, int min, int max) {
        // second traversal
        int[] frequency = new int[max - min + 1];

        for (int i = 0; i < arr.length; ++i) {
            int idx = arr[i] - min;
            ++frequency[idx];
        }

        // third traversal
        int count = 0;
        for (int i = 0; i < frequency.length; ++i) {
            for (int j = 0; j < frequency[i]; ++j) {
                int val = i + min;
                arr[count] = val;
                ++count;
            }
        }
    }

    // function to print array
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
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