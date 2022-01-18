import java.util.*;

public class Target_Sum_Pair_PrintAll {

    public static void targetSumPair(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                System.out.println(arr[left] + ", " + arr[right]);
                // ex: 160 = 60 + 100
                // then definitely we need to update both left and right, otherwise number of
                // comparison would increse uselesly.
                ++left;
                --right;
            } else if (arr[left] + arr[right] < target) {
                ++left;
            } else {
                --right;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr, target);
        scn.close();
    }

}