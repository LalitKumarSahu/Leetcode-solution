 import java.util.Arrays;
public class ClimbingStairs {
  // m-1 by using rec
class Solution {
    public int climbStairs(int n) {
       if(n == 1 || n == 2) return n;
        if(n < 0) return -1;
       return climbStairs(n-1) + climbStairs(n-2);
    }
}

// m-2 top down approach(memo)
class Solution2 {
    public int climbStairs(int n) {
       int dp[] = new int[n+1];
       Arrays.fill(dp, -1);

       return rec(n, dp);
    }
    public int rec(int n , int dp[]){
        if( n == 1 || n == 2){
            dp[n] = n;
            return dp[n];
        }
          if(n < 0) return -1;
        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = rec(n-1, dp) + rec(n-2, dp);
        return dp[n];
    }
}

// m-3 bottom up approach(tab)
class Solution3 {
    public int climbStairs(int n) {
        if( n == 1 || n == 2){
            return n;
        }
       int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int state = 3; state <= n; state++){
            dp[state] = dp[state-1] + dp[state-2];
        }
        return dp[n];
    }
   
}

// m-4 optimization
class Solution4 {
    public int climbStairs(int n) {
        if( n == 1 || n == 2){
            return n;
        }
        
        
        int prev2 = 1;
        int prev1 = 2;
        int ans = 0;

        for(int state = 3; state <= n; state++){
            ans = prev2 + prev1;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
   
}
}
