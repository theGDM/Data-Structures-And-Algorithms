import java.util.*;
// two pointer approach

public class Target_Sum_Pair {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left != right) {
            if (numbers[left] + numbers[right] > target) {
                --right;
            } else if (numbers[left] + numbers[right] < target) {
                ++left;
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int[] res = twoSum(arr, target);
        System.out.print("[ ");
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + " ");
        }
        System.out.print("]");
        scn.close();
    }
}