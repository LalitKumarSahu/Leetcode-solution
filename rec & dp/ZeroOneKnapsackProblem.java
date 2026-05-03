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
}
