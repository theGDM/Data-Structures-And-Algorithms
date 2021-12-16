import java.util.*;

public class print_targetsum_using_equaltotarget {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        printTargetSumSubsets(arr, 0, "", 0, target);
        scn.close();
    }

    // set is the subset
    // remTarget is remaining of target
    // tar is target

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int isEqualTarget, int target) {
        // base case
        if (idx == arr.length) {
            if (isEqualTarget == target) {
                System.out.println(set + ".");
            }
            return;
        }

        // pruning step
        if (isEqualTarget > target) {
            return;
        }

        // yes call
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", isEqualTarget + arr[idx], target);

        // no call
        printTargetSumSubsets(arr, idx + 1, set, isEqualTarget, target);
    }

}