import java.util.*;

public class Spiral_Display {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][] mat = new int[n][m];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        mat[i][j] = scn.nextInt();
      }
    }

    int frow = 0, lrow = n - 1, fcol = 0, lcol = m - 1;
    int count = 0;
    while (true) {
      //left wall -> (T-B)
      for (int i = frow; i <= lrow; ++i) {
        System.out.println(mat[i][fcol]);
        ++count;
        if(count == n*m) return;
      }
      ++fcol;

      //bottom wall -> (L-R)
      for (int j = fcol; j <= lcol; ++j) {
        System.out.println(mat[lrow][j]);
        ++count;
        if(count == n*m) return;
      }
      --lrow;

      //right wall -> (B-T);
      for (int k = lrow; k >= frow; --k) {
        System.out.println(mat[k][lcol]);
        ++count;
        if(count == n*m) return;
      }
      --lcol;

      //top wall -> (R-L)
      for (int l = lcol; l >= fcol; --l) {
        System.out.println(mat[frow][l]);
        ++count;
        if(count == n*m) return;
      }
      ++frow;
      scn.close();
    }
  }
}