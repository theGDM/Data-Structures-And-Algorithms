
//brute force approach
import java.util.*;

public class Target_Sum_Pair_Brute {
    public static void twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; ++i) {
            for (int j = i + 1; j < numbers.length; ++j) {
                if (numbers[i] + numbers[j] == target) {
                    System.out.println("{" + numbers[i] + "," + numbers[j] + "}");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        twoSum(arr, target);
        scn.close();
    }
}