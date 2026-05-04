import java.util.Arrays;

public class uniquePath {
  class Solution {
    // tc-O(2^N+M)
    public int uniquePaths(int m, int n) {
        return gridWay(m-1,n-1);   
    }
    public int gridWay(int m, int n){
        if(m == 0 && n == 0) return 1;

        if(m < 0||n < 0 ) return 0;

        int w1 = gridWay( m-1, n);
        int w2 = gridWay(m, n-1);
        return w1 + w2;
         
    }
}
// m-2 by using top down approach
 class Solution2 {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            Arrays.fill(dp[i], -1);
        }
        return gridWay(m,n,dp);   
    }
    public int gridWay(int m, int n, int dp[][]){
        if(m == 1 && n == 1) {
            dp[m][n] = 1;
            return 1;
        }
        if( m == 0  || n == 0) {
            dp[m][n] = 0;
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int w1 = gridWay( m-1, n, dp);
        int w2 = gridWay( m, n-1, dp);
          dp[m][n] =  w1 + w2;
          return w1 + w2;
         
    }

 }
}
