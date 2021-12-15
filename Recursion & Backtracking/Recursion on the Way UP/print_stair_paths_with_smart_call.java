import java.util.*;

public class print_stair_paths_with_smart_call {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");
        scn.close();
    }

    public static void printStairPaths(int n, String path) {
        // positive base case
        if (n == 0) {
            System.out.println(path);
            return;
        }

        // faiths
        if (n - 1 >= 0) {
            printStairPaths(n - 1, path + 1);
        }

        if (n - 2 >= 0) {
            printStairPaths(n - 2, path + 2);
        }

        if (n - 3 >= 0) {
            printStairPaths(n - 3, path + 3);
        }

    }

}