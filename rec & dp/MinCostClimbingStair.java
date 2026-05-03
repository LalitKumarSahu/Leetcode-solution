// import java.util.Arrays;
public class MinCostClimbingStair {
  //f(n) =min( c[n-1] + f(n-1)  ,  (c[n-2] + f(n-2) ) // n-1 she jump karne tak ka cost + n-1 tak aane ka cost

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return rec(n, cost);
        
    }
    public int rec(int n, int cost[]){
        // yha tak aane ka koi cost nhi hai yha se jane ka cost hai
        if(n == 0 || n == 1) return 0;

            int oneStep = cost[n-1] + rec(n-1, cost);
            int secStep = cost[n-2] + rec(n-2, cost);
            return Math.min(oneStep, secStep);
        
    }
}

//top to bottom
class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(n, cost, dp);
        
    }
    public int rec(int n, int cost[], int dp[]){
        // yha tak aane ka koi cost nhi hai yha se jane ka cost hai
        if(n == 0 || n == 1){
            dp[n] = 0;
            return 0;
        }
        if(dp[n] != -1)return dp[n];

            int oneStep = cost[n-1] + rec(n-1, cost, dp);
            int secStep = cost[n-2] + rec(n-2, cost, dp);
            dp[n] =  Math.min(oneStep, secStep);
            return dp[n];
        
    }
}

//bottom to top
class Solution3 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int state = 2; state <= n; state++){
            int oneStep = cost[state-1] + dp[state-1];
            int secStep = cost[state-2] + dp[state-2];
            dp[state] = Math.min(oneStep, secStep);
        }
        return dp[n];
    }
 
}

// optimization
class Solution4 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
      
        int prev2 = 0;
        int prev1 = 0;
        int ans = 0;
        for(int state = 2; state <= n; state++){
            int oneStep = cost[state-1] + prev1;
            int secStep = cost[state-2] + prev2;
            ans = Math.min(oneStep, secStep);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
 
}


}
