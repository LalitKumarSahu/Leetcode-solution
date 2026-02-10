import java.util.HashMap;

public class FirstCompletelyPaintRowOrCol {
  class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int rowCount[] = new int[n];
        int colCount[] = new int[m];
        
        // num -> (row, col)
        HashMap<Integer,int[]>map = new HashMap<>();
        // n * m
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        // iterate on arr = n * m
        int totalCell = n * m;
        for(int i = 0; i<totalCell; i++){
           int cell[] = map.get(arr[i]);
           rowCount[cell[0]]++;
           colCount[cell[1]]++;
           if(rowCount[cell[0]] == m || colCount[cell[1]] == n ){
            return i;
           }
        }
        return -1;
    }
}
}
