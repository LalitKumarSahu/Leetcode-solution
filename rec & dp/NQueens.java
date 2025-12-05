import java.util.ArrayList;
import java.util.List;

public class NQueens {
  class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        NQueens(0,board, n, result);
        return result;
    } 

    public void NQueens(int col, char [][] board, int n, List<List<String>> result) {
        if(col == n) {
            printBoard(board, result);
            return;
        }

        for(int row = 0; row < n; row++) {
            if(possible(row, col, board, n)) {
                board[row][col] = 'Q';
                NQueens(col + 1, board, n, result);
                board[row][col] = '.';
            }
        }
    }

    public boolean possible(int row, int col, char[][] board, int n) {
        int dupRow = row;
        int dupCol = col;

        // upper - left
        while(row >=0 && col >= 0) {
            if(board[row--][col--] == 'Q') return false;
        }

        row = dupRow;
        col = dupCol;
        // Left
        while(col >= 0) {
            if(board[row][col--] == 'Q') return false;
        }

        row = dupRow;
        col = dupCol;
        // bottom - left;
        while(row < n && col >= 0) {
            if(board[row++][col--] == 'Q') return false;
        }

        return true;
    }

    public void printBoard(char[][] board, List<List<String>> result) {
        ArrayList<String> temp = new ArrayList<>();
        for(char[] row : board) {
            temp.add(new String(row));
        }
        result.add(temp);
    }
}
  
}
