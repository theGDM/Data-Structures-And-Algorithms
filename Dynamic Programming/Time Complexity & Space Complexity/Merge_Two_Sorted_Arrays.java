import java.util.*;

public class Merge_Two_Sorted_Arrays {

    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        // write your code here
        int n = a.length;
        int m = b.length;
        int[] c = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                ++k;
                ++i;
            } else {
                c[k] = b[j];
                ++k;
                ++j;
            }
        }

        // inserting remaining elements of array a in resultant array c,
        // if there is any.
        while (i < n) {
            c[k] = a[i];
            ++k;
            ++i;
        }

        // inserting remaining elements of array b in resultant array c,
        // if there is any.
        while (j < m) {
            c[k] = b[j];
            ++k;
            ++j;
        }

        return c;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
        scn.close();
    }
}