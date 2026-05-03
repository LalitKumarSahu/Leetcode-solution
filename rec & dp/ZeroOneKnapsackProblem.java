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
// m-3 bottom up

class Solution3 {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int dp[][] = new int[n][W+1];
        // base case W = 0
        for(int i = 0; i<n; i++){
            dp[i][0] = 0;
        }
        // idx =0
        for(int c = 0; c < W+1; c++){
            if(wt[0] <= c){
                dp[0][c] = val[0];
            }else{
                dp[0][c] = 0;
            }
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<=W; j++){
                 int pick = 0;
                    if(wt[i] <= j){
                        pick = val[i] + dp[i-1][j-wt[i]];//rec(j - wt[i], val, wt, i-1, dp);
                    }
                    int noPick = 0 + dp[i-1][j];//rec(j, val, wt, i-1, dp);
                    
                   dp[i][j] =  Math.max(pick, noPick);
            }
        }
        return dp[n-1][W];
    }

}
// m-3 space optimization

class Solution4 {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int prev[] = new int[W+1];
        prev[0] = 0;
        // base case W = 0
        // for(int i = 0; i<n; i++){
        //     dp[i][0] = 0;
        // }
        // idx =0
        for(int c = 0; c < W+1; c++){
            if(wt[0] <= c){
                prev[c] = val[0];
            }else{
                prev[c] = 0;
            }
        }
        for(int i=1; i<n; i++){
            int curr[] = new int[W+1];
            curr[0] = 0;
            for(int j=0; j<=W; j++){
                 int pick = 0;
                    if(wt[i] <= j){
                        pick = val[i] + prev[j-wt[i]];//rec(j - wt[i], val, wt, i-1, dp);
                    }
                    int noPick = 0 + prev[j];//rec(j, val, wt, i-1, dp);
                    
                   curr[j] =  Math.max(pick, noPick);
            }
            prev = curr;
        }
        return prev[W];
    }

}
}
