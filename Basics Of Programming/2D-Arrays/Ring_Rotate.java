import java.util.*;

public class Ring_Rotate {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    //matrix declaration and initialisation
    int[][] mat = new int[n][m];

    //getting element in matrix
    for (int i = 0; i < mat.length; ++i) {
      for (int j = 0; j < mat[0].length; ++j) {
        mat[i][j] = scn.nextInt();
      }
    }

    //left -> 0, bottom -> 1, left -> 2, top -> 3
    int currCol = 0, currRow = 0;
    int prevCol = 0,prevRow = 0;
    int dir = 0;

    while ((currRow <= 0 || currRow < n) && (currCol <= 0 || currCol < m)){
      //changing direction when we get 1
      if (mat[currRow][currCol] == 1) {
        dir = (dir + 1) % 4;
      }
      
       //maitaining previous row and col
       prevRow = currRow;
       prevCol = currCol;
       
      //traversing along direction
      if (dir == 0) {
        ++currCol; //left
      } else if (dir == 1) {
        ++currRow; //bottom
      } else if (dir == 2) {
        --currCol; //right
      } else {
        --currRow; //top
      }
    }

    //printing exit point
    System.out.println(prevRow);
    System.out.println(prevCol);
    scn.close();
  }

}