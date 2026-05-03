public class CountingBits {
  class Solution {
    public int[] countBits(int n) {
        int dp[] = new int[n+1];
        for(int i =1; i <= n; i++){
            // right sift by 1 for ignoring last bit and what is last digit  1 or 0 by (i & 1)
            dp[i] = dp[i >> 1] + dp[i & 1];
        }
        return dp;
    }
}
}
