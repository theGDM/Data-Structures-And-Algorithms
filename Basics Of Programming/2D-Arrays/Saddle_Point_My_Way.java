import java.util.*;

public class Saddle_Point_My_Way {

  public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    //matrix row and coloumn size(Square matrix)
    int n = scn.nextInt();
    
    //matrix declaration and initialisation
    int[][] mat = new int[n][n];

    //getting elements in matrix
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        mat[i][j] = scn.nextInt();
      }
    }

    int Row = 0;
    int min, max;
    int currRow, currCol = 0;;
    int colPos = 0;
    
    while (Row < n) {
      //checking min entry in each row
      min = Integer.MAX_VALUE;
      currCol = 0;
      while (currCol < n) {
        if (mat[Row][currCol] < min) {
          min = mat[Row][currCol];
          colPos = currCol;
        }
        ++currCol;
      }
      
      //checking min entry found in a row is max in col or not
      max = min;
      currRow = 0;
      while (currRow < n) {
        if (mat[currRow][colPos] > max) {
          max = mat[currRow][colPos];
          break;
        }
        ++currRow;
      }
      
      //checking min entry found in a row is same as max or not
      if (min == max) {
        System.out.println(min);
        scn.close();
        return;
      }
      ++Row;
    }
    
    //if there is not any saddle point then print this
    System.out.println("Invalid input");
    scn.close();
  }

}