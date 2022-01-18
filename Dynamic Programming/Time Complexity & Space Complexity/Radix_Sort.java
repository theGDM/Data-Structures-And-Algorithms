import java.util.*;

public class Radix_Sort {

    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        // finding maximum entry in arr
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // totaldigits in maximum entry of arr
        int totalDigits = digitCount(max);
        // performing the count sort, totaldigits times
        for (int i = 0; i < totalDigits; ++i) {
            countSort(arr, i);
        }
    }

    public static void countSort(int[] arr, int exp) {
        // making frequency array
        int[] frequency = new int[10];
        int placeValue = (int) Math.pow(10, exp);
        for (int i = 0; i < arr.length; ++i) {
            int currVal = arr[i] / placeValue;
            int idx = currVal % 10;
            ++frequency[idx];
        }

        // making prefix sum array
        int[] prefSum = new int[10];
        prefSum[0] = frequency[0];
        for (int i = 1; i < frequency.length; ++i) {
            prefSum[i] = prefSum[i - 1] + frequency[i];
        }

        // right to left traversal of original array
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; --i) {
            int currVal = arr[i] / placeValue;
            --prefSum[currVal % 10];
            int idx = prefSum[currVal % 10];
            res[idx] = arr[i];
        }

        // fill the original array by res array
        for (int i = 0; i < res.length; ++i) {
            arr[i] = res[i];
        }

        System.out.print("After sorting on " + placeValue + " place -> ");
        print(res);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int digitCount(int n) {
        return (int) Math.log10(n) + 1;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
        scn.close();
    }

}