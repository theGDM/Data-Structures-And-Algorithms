import java.util.*;

public class State_Of_Wakanda_2_Rectangular {
  public static void diagonalTraversalRectangular(int[][] mat) {
    int r = mat.length;
    int c = mat[0].length;

    //outer loop ->for diagonal -> gap
    //gap -> j-i
    for (int gap = 0; gap < c; ++gap) {
      //traversing the diagonal
      for (int i = 0, j = i + gap;i < r && j < c; ++i,++j) {
        System.out.println(mat[i][j]);
      }

    }
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int r = scn.nextInt();
    int c = scn.nextInt();
    
    //matrix declartion and iitialisation
    int[][] mat = new int[r][c];

    //getting elements in matrix
    for (int i = 0; i < r; ++i) {
      for (int j = 0; j < c; ++j) {
        mat[i][j] = scn.nextInt();
      }
    }

    diagonalTraversalRectangular(mat);
    scn.close();
  }

}