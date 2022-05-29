import java.io.*;
import java.util.*;

public class Main {
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

      boolean[][] visited = new boolean[arr.length][arr[0].length];
      int count = 0;
      for(int r = 0; r < arr.length; ++r){
         for(int c = 0; c < arr[0].length; ++c){
            if(arr[r][c] != 1 && visited[r][c] != true){
               ++count;
               exploreIsland(arr, r, c, visited);
            }
         }
      }
      System.out.println(count);
   }

   public static void exploreIsland(int[][] arr, int r, int c, boolean[][] visited){
      //mark visited
      visited[r][c] = true;

      //faith calls(Smart call)
      if(r - 1 >= 0 && c >= 0 && r < arr.length && c < arr[0].length && arr[r - 1][c] == 0 && visited[r - 1][c] == false){
         exploreIsland(arr, r - 1, c, visited); //up
      }

      if(r >= 0 && c >= 0 && r < arr.length && c + 1 < arr[0].length && arr[r][c + 1] == 0 && visited[r][c + 1] == false){
         exploreIsland(arr, r, c + 1, visited); //right
      }

      if(r >= 0 && c >= 0 && r + 1 < arr.length && c < arr[0].length && arr[r + 1][c] == 0 && visited[r + 1][c] == false){
         exploreIsland(arr, r + 1, c, visited); //down
      }
      
      if(r >= 0 && c - 1 >= 0 && r < arr.length && c < arr[0].length && arr[r][c - 1] == 0 && visited[r][c - 1] == false){
         exploreIsland(arr, r, c - 1, visited); //left
      }
   }

}
