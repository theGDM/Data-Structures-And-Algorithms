import java.io.*;
import java.util.*;

public class Main {
   public static void markLandArea(int r, int c, int[][] arr, boolean[][] visited){
      //(-ve)base case
      if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] == 1 || visited[r][c] == true){
         return;
      }

      //preorder work
      visited[r][c] = true;
      //faith calls
      markLandArea(r, c - 1, arr, visited); //left
      markLandArea(r + 1, c, arr, visited); //down
      markLandArea(r, c + 1, arr, visited); //right
      markLandArea(r - 1, c, arr, visited); //up
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      int ans = 0;
      boolean[][] visited = new boolean[arr.length][arr[0].length];
      for(int r = 0;r < arr.length; ++r){
         for(int c = 0;c < arr[0].length; ++c){
            if(arr[r][c] != 1 && visited[r][c] != true){
               ++ans;
               markLandArea(r, c, arr, visited);
            }
         }
      }
      System.out.println(ans);
      // for(int i = 0;i < visited.length; ++i){
      //    for(int j = 0;j < visited[0].length; ++j){
      //       System.out.print(visited[i][j] + "   ");
      //    }
      //    System.out.println();
      // }
   }
}
