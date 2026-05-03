public class ZeroOneKnapsackProblem {
  class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        return rec(W, val, wt, n-1);
    }
    public int rec(int W, int val[], int wt[], int idx){
        if(W == 0) return 0;
        
        if(idx == 0){
            if(wt[idx] <= W){
                return val[idx];
            }else{
                return 0;
            }
            
        }
        int pick = 0;
        
        if(wt[idx] <= W){
            pick = val[idx] + rec(W - wt[idx], val, wt, idx-1);
        }
        int noPick = 0 + rec(W, val, wt, idx-1);
        return Math.max(pick, noPick);
    }
}
// using top down approach
// m-2 topdown
class Solution2 {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=W; j++){
                dp[i][j] = -1;
            }
        }
        return rec(W, val, wt, n-1, dp);
    }
    public static int rec(int W, int val[], int wt[], int idx, int dp[][]){
        
        if(W == 0) {
            dp[idx][W] = 0;
            return 0;
        }
        
        if(idx == 0){
            if(wt[idx] <= W){
                dp[idx][W] = val[idx];
                return val[idx];
            }else{
                dp[idx][W] = 0;
                return 0;
            }
        }
        if(dp[idx][W] != -1){
            return dp[idx][W];
        }
        int pick = 0;
        if(wt[idx] <= W){
            pick = val[idx] + rec(W-wt[idx], val, wt, idx-1, dp);
        }
        int noPick = 0 + rec(W, val, wt, idx-1, dp);
        
       dp[idx][W] =  Math.max(pick, noPick);
       return dp[idx][W];
    }
}
}
