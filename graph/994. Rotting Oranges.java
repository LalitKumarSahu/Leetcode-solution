class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if (freshCount == 0) return 0; // at time zero

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] rottenLoc = q.remove();
                int r = rottenLoc[0];
                int c = rottenLoc[1];

                int[][] neighbors = {{r-1,c},{r,c+1},{r+1,c},{r,c-1}};

                for (int[] neighbor : neighbors) {
                    int nr = neighbor[0];
                    int nc = neighbor[1];
                    
                    //out of bound / rotten / visited
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && (grid[nr][nc] == 2 || grid[nr][nc] == 0)) {
                    continue;
                }
                       q.add(new int[]{nr, nc});
                        grid[nr][nc] = 2; // visited
                        
                    }
                }

               
            } 
                time++;
                freshCount -= q.size();
                if(freshCount == 0){
                    break;
                }
    }
        return (freshCount == 0)?time:-1;
    }
  }