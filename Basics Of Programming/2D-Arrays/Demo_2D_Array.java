import java.util.*;

public class Demo_2D_Array {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int r = scn.nextInt();
    int c = scn.nextInt();

    //declaration and initialisation of matrix array
    int[][] mat = new int[r][c];

    //accessing elements of matrix
    for (int i = 0; i < r; ++i) {
      for (int j = 0; j < c; ++j) {
        mat[i][j] = scn.nextInt();
      }
    }
    
    //printing elements of array
    for (int i = 0; i < r; ++i) {
      for (int j = 0; j < c; ++j) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
    scn.close();
  }
}