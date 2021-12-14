import java.util.*;

public class print_maze_path_with_jumps {

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

        // moving right and getting all the paths with jumps(faith call)
        for (int jump = 1; jump <= dc; ++jump) {
            printMazePaths(sr, sc + jump, dr, dc, output + "h" + jump);
        }

        // moving down and getting all the paths with jumps(faith call)
        for (int jump = 1; jump <= dr; ++jump) {
            printMazePaths(sr + jump, sc, dr, dc, output + "v" + jump);
        }

        // moving diagonally and getting all the paths with jumps(faith call)
        for (int jump = 1; jump <= Math.min(dr, dc); ++jump) {
            printMazePaths(sr + jump, sc + jump, dr, dc, output + "d" + jump);
        }
    }

}