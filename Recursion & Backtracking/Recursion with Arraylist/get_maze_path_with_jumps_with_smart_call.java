import java.util.*;

public class get_maze_path_with_jumps_with_smart_call {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        ArrayList<String> res = getMazePaths(0, 0, rows - 1, cols - 1);
        System.out.println(res);
        scn.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // positive base case
        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();

        // moving right and getting all the paths with jumps(faith call)
        for (int jump = 1; sc + jump <= dc; ++jump) {
            ArrayList<String> rightPaths = getMazePaths(sr, sc + jump, dr, dc);
            for (String str : rightPaths) {
                ans.add("h" + jump + str);
            }
        }

        // moving down and getting all the paths with jumps(faith call)
        for (int jump = 1; sr + jump <= dr; ++jump) {
            ArrayList<String> downPaths = getMazePaths(sr + jump, sc, dr, dc);
            for (String str : downPaths) {
                ans.add("v" + jump + str);
            }
        }

        // moving diagonally and getting all the paths with jumps(faith call)
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; ++jump) {
            ArrayList<String> diagonalPaths = getMazePaths(sr + jump, sc + jump, dr, dc);
            for (String str : diagonalPaths) {
                ans.add("d" + jump + str);
            }
        }

        return ans;
    }

}