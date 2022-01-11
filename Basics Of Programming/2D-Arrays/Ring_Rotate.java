import java.util.*;

public class Ring_Rotate {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    // matrix declaration and initialisation
    int[][] mat = new int[n][m];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        mat[i][j] = scn.nextInt();
      }
    }

    int s = scn.nextInt();// shell of number
    int r = scn.nextInt();// number of rotates

    for (int i = 0; i < r; ++i) {
      int frow = s - 1, fcol = s - 1;
      int lrow = n - s, lcol = m - s;
      int temp = mat[frow][fcol];
      for (int p = fcol; p < lcol; ++p) {
        mat[frow][p] = mat[frow][p + 1];
      }

      for (int j = frow; j < lrow; ++j) {
        mat[j][lcol] = mat[j + 1][lcol];
      }

      for (int k = lcol; k > fcol; --k) {
        mat[lrow][k] = mat[lrow][k - 1];
      }

      for (int l = lrow; l > frow + 1; --l) {
        mat[l][fcol] = mat[l - 1][fcol];
      }

      mat[frow + 1][fcol] = temp;
    }

    display(mat);
    scn.close();
  }

  public static void display(int[][] mat) {
    for (int i = 0; i < mat.length; ++i) {
      for (int j = 0; j < mat[0].length; ++j) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }

}