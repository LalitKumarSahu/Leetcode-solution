public class PerfectSumProblem {
  class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        return rec(nums, n-1, target);
        
    }
    public int rec(int nums[], int idx, int target){
        if(idx==0){
            if(target == 0 && nums[idx] == 0){
                return 2;
            }else if(target == 0){
                return 1;
            }else if(target == nums[idx]){
                return 1;
            }else{
                return 0;
            }
        }
        int pick  = 0;
        if(nums[idx] <= target){
            pick = rec(nums, idx-1, target-nums[idx]);
        }
        int noPick = rec(nums, idx-1, target);
        
        return pick + noPick;
    }
}
  
class Solution2 {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n][target+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<target+1; j++){
                dp[i][j] = -1;
            }
        }
        return perfectSum(nums, target, n-1,dp);
        
    }
    public int perfectSum(int[] nums, int target, int idx, int dp[][]) {
        if(idx == 0){
            if(target == 0 && nums[0] == 0){
                dp[idx][target] = 2;
                return 2;
            }
            else if(target == 0) {
                dp[idx][target] = 1;
                return 1;
            }
            else if(target == nums[idx]){
                 dp[idx][target] = 1;
                 return 1;
            }
            else {
                dp[idx][target] = 0;
                return 0;
            }
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        int pick = 0;
        if(nums[idx] <= target){
            pick = perfectSum(nums, target-nums[idx], idx-1, dp);
        }
        int noPick = perfectSum(nums, target, idx-1, dp);
        dp[idx][target] = pick + noPick;
        return dp[idx][target];
    }
}
}
