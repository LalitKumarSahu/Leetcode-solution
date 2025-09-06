class Solution {
    // --------tc-O(n*m)------------->
     int rows;
    int cols;
    public int numIslands(char[][] grid) {
       rows = grid.length;
       cols = grid[0].length;
       int islands = 0;
       boolean vis[][] = new boolean[rows][cols];

       for(int i=0; i<rows; i++){
         for(int j=0;j<cols; j++){
            if(grid[i][j] == '1' && !vis[i][j]){
                dfs(grid, i, j, vis);
                islands++;
            }
         }
       }
       return islands;
       
    }
    public void dfs(char[][] grid, int row, int col, boolean vis[][] ){
      // ---------out of bound case------------>
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || vis[row][col]){
            return;
        }
        vis[row][col] = true;

        int adjList[][] = {
            {row-1, col},{row, col+1},{row+1, col},{row, col-1}
        };
        for(int neigh[] : adjList){
          dfs(grid, neigh[0], neigh[1], vis);
        }
    }
}
