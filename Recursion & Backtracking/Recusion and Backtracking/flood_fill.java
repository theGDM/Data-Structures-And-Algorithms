import java.util.*;

public class flood_fill {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        boolean[][] visit = new boolean[n][m];

        floodfill(arr, 0, 0, "", visit);
        scn.close();
    }

    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String path, boolean[][] visit) {
        int dr = maze.length - 1;
        int dc = maze[0].length - 1;

        // negative base case
        if (sr > dr || sc > dc || sr < 0 || sc < 0 || maze[sr][sc] == 1 || visit[sr][sc] == true) {
            return;
        }

        // positive base case
        if (sr == dr && sc == dc) {
            System.out.println(path);
            return;
        }

        // marking visited for the current node
        visit[sr][sc] = true;

        // faith
        floodfill(maze, sr - 1, sc, path + "t", visit);// moving top
        floodfill(maze, sr, sc - 1, path + "l", visit);// moving left
        floodfill(maze, sr + 1, sc, path + "d", visit);// moving down
        floodfill(maze, sr, sc + 1, path + "r", visit);// moving right

        // backtracking
        visit[sr][sc] = false;
    }
}
