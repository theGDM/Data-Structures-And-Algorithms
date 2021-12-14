import java.util.*;

public class print_maze_paths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        printMazePaths(0, 0, rows - 1, cols - 1, "");
        scn.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String output) {
        // positive base case
        if (sr == dr && sc == dc) {
            System.out.println(output);
            return;
        }

        // negative base case
        if (sr > dr || sc > dc) {
            return;
        }

        // faiths
        printMazePaths(sr, sc + 1, dr, dc, output + "h");// for right path
        printMazePaths(sr + 1, sc, dr, dc, output + "v");// for down path
    }

}