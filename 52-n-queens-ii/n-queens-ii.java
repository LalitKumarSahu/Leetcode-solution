import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<String>> result = new ArrayList<>();
   static int count;
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);
        return result;
    }

    public int totalNQueens(int n) {
        // Initialize the board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
       count = 0; // Reset counter before counting
        nQueens(board, 0);
        return count; // Return the total number of solutions
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // Vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void nQueens(char[][] board, int row) {
        // Base case
        if (row == board.length) {
            printBoard(board);
            count++; // Increment the counter for each solution found
            return;
        }
        // Column loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1); // Function call
                board[row][j] = '.'; // Backtracking step
            }
        }
    }

    private void printBoard(char[][] board) {
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                str.append(board[i][j]);
            }
            ls.add(str.toString());
        }
        result.add(ls);
    }


}
