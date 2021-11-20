import java.util.*;

public class Rotate_By_90_degree_ACW{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] mat = new int[n][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        transpose(mat);
        reverseEachCol(mat);
        display(mat);
        scn.close();
    }

    public static void reverseEachCol(int[][] mat) {
        for (int j = 0; j < mat[0].length; ++j) {
            reverse(mat,j);
        }
    }

    public static void reverse(int[][] mat,int col){
        int top = 0;
        int bottom = mat.length - 1;
        while (top < bottom) {
            int temp = mat[top][col];
            mat[top][col] = mat[bottom][col];
            mat[bottom][col] = temp;
            ++top;
            --bottom;
        }
    }

    public static void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; ++i) {
            for (int j = i + 1; j < mat[0].length; ++j) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
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