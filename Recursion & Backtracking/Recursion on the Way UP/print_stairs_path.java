import java.util.*;

public class print_stairs_path {

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

        // negative base case
        if (n < 0) {
            return;
        }

        // faiths
        printStairPaths(n - 1, path + 1);
        printStairPaths(n - 2, path + 2);
        printStairPaths(n - 3, path + 3);
    }

}