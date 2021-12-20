import java.util.*;

public class print_Knight_Tours {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = scn.nextInt();
        int col = scn.nextInt();

        int[][] chess = new int[n][n];
        printKnightsTour(chess, row, col, 1);
        scn.close();
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        // negative base case
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] != 0) {
            return;
        }

        // positive base case
        if (upcomingMove == chess.length * chess[0].length) {
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        // visiting current node
        chess[r][c] = upcomingMove;

        // faiths -> options available to a node(a block of chess)
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1);
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1);
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1);
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1);

        // unvisiting the node
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}