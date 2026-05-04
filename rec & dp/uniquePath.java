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
}
