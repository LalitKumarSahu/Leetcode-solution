class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        // Base case: poora word mil gaya
        if (index == word.length()) return true;

        // Out of bounds or mismatch
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore 4 directions
        boolean found = dfs(board, i + 1, j, index + 1, word)
                     || dfs(board, i - 1, j, index + 1, word)
                     || dfs(board, i, j + 1, index + 1, word)
                     || dfs(board, i, j - 1, index + 1, word);

        // Backtrack
        board[i][j] = temp;

        return found;
    }
}
