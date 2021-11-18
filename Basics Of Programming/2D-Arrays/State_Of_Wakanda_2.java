import java.util.*;

public class State_Of_Wakanda_2 {
  public static void diagonalTraversal(int[][] mat) {
    // int r = mat.length;
    int c = mat[0].length;

    //outer loop ->for diagonal -> gap
    //gap -> j-i
    for (int gap = 0; gap < c; ++gap) {
      //traversing the diagonal
      for (int i = 0, j = i + gap; j < c; ++i,++j) {
        System.out.println(mat[i][j]);
      }

    }
  }

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    //as it is square matrix
    int r, c;
    r = n;
    c = n;
    
    //matrix declartion and initialisation
    int[][] mat = new int[r][c];

    //getting elements in matrix
    for (int i = 0; i < r; ++i) {
      for (int j = 0; j < c; ++j) {
        mat[i][j] = scn.nextInt();
      }
    }

    diagonalTraversal(mat);
    scn.close();
  }

}