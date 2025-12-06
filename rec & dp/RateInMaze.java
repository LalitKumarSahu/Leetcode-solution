import java.util.ArrayList;
import java.util.List;

public class RateInMaze {
  class Solution {

    public List<String> findPath(int[][] grid) {
        int n = grid.length;

        List<String> paths = new ArrayList<>();
        boolean vis[][] = new boolean[n][n];

        // If starting cell is blocked
        if (grid[0][0] == 0)
            return paths;

        solveUtil(grid, 0, 0, vis, n, "", paths);

        return paths;
    }

    // Recursive backtracking
    public void solveUtil(int[][] grid, int x, int y,
                          boolean vis[][], int n,
                          String path, List<String> paths) {

        // Reached destination
        if (x == n - 1 && y == n - 1) {
            paths.add(path);
            return;
        }

        // Mark visited
        vis[x][y] = true;

        // Move Down (D)
        if (isSafe(grid, x + 1, y, vis, n))
            solveUtil(grid, x + 1, y, vis, n, path + "D", paths);

        // Move Left (L)
        if (isSafe(grid, x, y - 1, vis, n))
            solveUtil(grid, x, y - 1, vis, n, path + "L", paths);

        // Move Right (R)
        if (isSafe(grid, x, y + 1, vis, n))
            solveUtil(grid, x, y + 1, vis, n, path + "R", paths);

        // Move Up (U)
        if (isSafe(grid, x - 1, y, vis, n))
            solveUtil(grid, x - 1, y, vis, n, path + "U", paths);

        // Backtrack
        vis[x][y] = false;
    }

    // Check if move is safe
    public boolean isSafe(int[][] grid, int x, int y, boolean vis[][], int n) {
      // x row index 0 se n-1 tak allowed
      //y column index 0 se n-1 tak allowed
      return (x >= 0 && x < n &&
                y >= 0 && y < n &&
                grid[x][y] == 1 &&
                !vis[x][y]);
    }
}

}
