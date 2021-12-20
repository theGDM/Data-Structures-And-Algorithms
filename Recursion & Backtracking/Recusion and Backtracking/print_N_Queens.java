import java.util.*;

public class print_N_Queens {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] chess = new boolean[n][n];
        printNQueens(chess, "", 0);
        scn.close();
    }

    public static boolean isQueenSafe(boolean[][] chess, int row, int col) {
        // upward coloumn
        for (int i = 0; i < row; ++i) {
            if (chess[i][col] == true) {
                return false;
            }
        }

        // upward left diagonal
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (chess[i][j] == true) {
                return false;
            }
            --i;
            --j;
        }

        // upward right diagonal
        i = row;
        j = col;
        while (i >= 0 && j < chess[0].length) {
            if (chess[i][j] == true) {
                return false;
            }
            --i;
            ++j;
        }

        return true;
    }

    public static void printNQueens(boolean[][] chess, String qsf, int row) {
        // base class
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }

        // faith -> no of options(no of coloumns)
        for (int col = 0; col < chess[0].length; ++col) {
            if (isQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = false;
            }
        }
    }
}