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
 
// m-3 by using bottom up approach
 class Solution3 {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                if( i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(i == 1 && j == 1){
                    dp[i][j] = 1;
                }else{
                    int w1 = dp[i-1][j];
                    int w2 = dp[i][j-1];
                    dp[i][j] = w1 + w2;
                }
            }
        }
        return dp[m][n];   
    }
   
 }
}
