class Solution {
    int rows;
    int cols;
    // currColor = img[sr][sc]
    public  void dfs(int row, int col, int newColor, int currColor, boolean vis[][],int[][] image ){

//out of bound cases, visited & color not same->image[row][col]  != currColor (1 !=1)
    if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col]  != currColor || vis[row][col]){
        return;
    }
    vis[row][col] = true;
    image[row][col] = newColor;

    int adjList[][] = {{row-1, col},{row, col+1},{row+1, col},{row, col-1}};

    for(int neigh[] : adjList){
       dfs(neigh[0], neigh[1], newColor, currColor, vis, image);
    }
 }
  
  //tc : rows * colsf

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     rows = image.length;
     cols = image[0].length;
     boolean vis[][] = new boolean[rows][cols];
     dfs(sr, sc, color,image[sr][sc], vis, image );
     return image;
    }
}


// m-2 bfs , tc : rows * cols
class Solution {
   int rows; int cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        int currColor = image[sr][sc];
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int node[] = q.remove();
            int row = node[0];
            int col = node[1];

             int adjList[][] = {{row-1, col},{row, col+1},{row+1, col},{row, col-1}};

            for(int neigh[] : adjList){
                int r = neigh[0];
                int c = neigh[1];
             if(r < 0 || r >= rows || c < 0 || c >= cols || image[r][c]  != currColor || image[r][c] == color){
              continue;
            }
            q.add(new int[]{r, c});
            image[r][c] = color;
            
            }
        }
    return image;

      
    }
}
