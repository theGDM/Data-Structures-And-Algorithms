import java.util.*;

public class get_maze_paths_with_smart_call {

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
    if (sr == dr && sc == dc) {
      // positive base case -> 1 size
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> ans = new ArrayList<>();

    if (sc <= dc) {
      ArrayList<String> rightPaths = getMazePaths(sr, sc + 1, dr, dc);
      for (String str : rightPaths) {
        ans.add('h' + str);
      }
    }

    if (sr <= dr) {
      ArrayList<String> downPaths = getMazePaths(sr + 1, sc, dr, dc);
      for (String str : downPaths) {
        ans.add('v' + str);
      }
    }

    return ans;
  }

}
