import java.util.*;

public class State_Of_Wakanda_1 {
  public static void waveTraversal(int[][] mat) {
    int r = mat.length;//rows
    int c = mat[0].length;//coloumn

    //coloumn by coloumn by print
    for (int j = 0; j < c; ++j) {
      if (j % 2 == 0) {
        for (int i = 0; i < r; ++i) {
            System.out.println(mat[i][j] + " ");
        }
      }else{
         for (int i = r-1; i >= 0; --i) {
            System.out.println(mat[i][j] + " ");
        } 
      }
    }
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int r = scn.nextInt();
    int c = scn.nextInt();

    int[][] mat = new int[r][c];

    for (int i = 0; i < r; ++i) {
      for (int j = 0; j < c; ++j) {
        mat[i][j] = scn.nextInt();
      }
    }

    waveTraversal(mat);
    scn.close();
  }

}