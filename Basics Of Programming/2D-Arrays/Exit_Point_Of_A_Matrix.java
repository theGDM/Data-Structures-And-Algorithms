import java.util.*;

public class Exit_Point_Of_A_Matrix {

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
    int dir = 0;

    while ((currRow <= 0 || currRow < n) && (currCol <= 0 || currCol < m)){
      //changing direction when we get 1 in matrix
      if (mat[currRow][currCol] == 1) {
        if (dir == 0) dir = 1;
        else if (dir == 1) dir = 2;
        else if (dir == 2) dir = 3;
        else if (dir == 3) dir = 0;
      }

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
    if(currCol == m){ //exit from right wall
        System.out.println(currRow);
        System.out.println(m-1);
    }else if(currRow == n){ //exit from bottom wall
        System.out.println(n-1);
        System.out.println(currCol);
    }else if(currCol == -1){ //exit from left wall
        System.out.println(currRow);
        System.out.println(0);
    }else { //exit from top wall
        System.out.println(0);
        System.out.println(currCol);
    }
    scn.close();
  }

}