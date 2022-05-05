import java.io.*;
import java.util.*;

public class Main {
   public static int dir[][] = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
   public static void markLandArea(int r, int c, int[][] arr){
      arr[r][c] = 2; //mark land area to 2, so that we don't visit there again
      for(int i = 0;i < 4; ++i){
         int nr = r + dir[i][0]; //new row
         int nc = c + dir[i][1]; //new col
         if(nr >= 0 && nc >= 0 && nr < arr.length && nc < arr[0].length && arr[nr][nc] == 0){
            markLandArea(nr, nc, arr);
         }
      }
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
      for(int r = 0;r < arr.length; ++r){
         for(int c = 0;c < arr[0].length; ++c){
            if(arr[r][c] == 0){
               ++ans;
               markLandArea(r, c, arr);
            }
         }
      }
      System.out.println(ans);
   }
}
