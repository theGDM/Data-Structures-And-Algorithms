import java.util.*;

public class Bubble_Sort_Optimized {
    public static void bubbleSort(int[] arr) {
        // write your code here
        boolean flag = false;
        for (int i = arr.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (isSmaller(arr, j + 1, j)) {
                    swap(arr, j + 1, j);
                    flag = true;
                }
            }
            // if after one iterartion there is no swap done, that means our array is
            // already sorted, so we not need to iterated again, we can just return so
            // we would have T.C. at best case is o(n) otherwise it would be o(n2), if
            // we do not provide some check after 1st iteration.
            if (flag == false) {
                return;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
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
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        bubbleSort(arr);
        print(arr);
        scn.close();
    }
}
