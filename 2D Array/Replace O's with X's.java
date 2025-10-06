// User function Template for Java
// tc:O(N) + O(n*M) * 4--O(N) = first and last row and column + traversing whole matrix + dfs calls
// sc:O(N*M) + O(N*M) = visited array + recursion stack space
class Solution {
    static char[][] fill(char mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        int vis[][] = new int[n][m];

        // Traverse first and last row
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delRow, delCol, n, m);
            }
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delRow, delCol, n, m);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delRow, delCol, n, m);
            }
            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, delRow, delCol, n, m);
            }
        }

        // Convert unvisited 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }

    static void dfs(int r, int c, int vis[][], char mat[][], int[] delRow, int[] delCol, int n, int m) {
        vis[r][c] = 1;
        for (int k = 0; k < 4; k++) {
            int newR = r + delRow[k];
            int newC = c + delCol[k];
            if (newR >= 0 && newR < n && newC >= 0 && newC < m
                    && vis[newR][newC] == 0 && mat[newR][newC] == 'O') {
                dfs(newR, newC, vis, mat, delRow, delCol, n, m);
            }
        }
    }
}
