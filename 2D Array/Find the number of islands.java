class Solution {
    // Function to count the number of islands
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'L'){  // Land found
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    // DFS to mark all connected land
    private void dfs(char[][] grid, int i, int j, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 'W' || grid[i][j] == '2'){
            return;
        }

        grid[i][j] = '2'; // mark visited

        // 4 directions
        dfs(grid, i - 1, j, n, m); // up
        dfs(grid, i + 1, j, n, m); // down
        dfs(grid, i, j - 1, n, m); // left
        dfs(grid, i, j + 1, n, m); // right
    }
}
