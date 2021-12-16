import java.util.*;

public class print_targetsum_using_remtarget {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        printTargetSumSubsets(arr, 0, "", target);
        scn.close();
    }

    // set is the subset
    // remTarget is remaining of target
    // tar is target

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int remTarget) {
        // base case
        if (idx == arr.length) {
            if (remTarget == 0) {
                System.out.println(set + ".");
            }
            return;
        }

        // pruning step
        if (remTarget < 0) {
            return;
        }

        // yes call
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", remTarget - arr[idx]);

        // no call
        printTargetSumSubsets(arr, idx + 1, set, remTarget);
    }

}