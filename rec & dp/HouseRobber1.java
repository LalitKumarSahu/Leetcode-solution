import java.util.Arrays;

public class HouseRobber1 {
  class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        return rec(nums, n-1);
    }
    public int rec(int nums[], int idx){
        if(idx == 0) return nums[0];

        if(idx == -1) return 0;

        int pick = nums[idx] + rec(nums, idx-2);
        int noPick = 0 + rec(nums, idx-1);

        return Math.max(pick, noPick);

    }
}
  
// top to bottom
class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n+1];  // shifting logic bcz array can not hold negative idx
        Arrays.fill(dp, -1);
        return robUtil(nums, n, dp);
    } 
    public int robUtil(int[] nums, int i, int[] dp) {
         if (i == 1){ // i == 0
            dp[i] = nums[0];
            return nums[0];
        }
        if (i == 0) {
            dp[i] = 0;
            return 0;
        }
       if(dp[i] != -1){
        return dp[i];
       }
       int pick = nums[i-1] + robUtil(nums, i-2, dp);
       int noPick = 0 + robUtil(nums, i-1, dp);

       dp[i] = Math.max(pick, noPick);
       return dp[i];
    }
}
//m-3 by tabulation
class Solution3 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1]; // Use n+1 to align with robUtil's index
         dp[0] = 0;
         dp[1] = nums[0];
         
         for(int i = 2; i < n+1; i++ ){
            int pick = nums[i - 1] + dp[i-2];
            int noPick = 0 + dp[i-1];
             dp[i] = Math.max(pick, noPick);
         }
         return dp[n];
    }

}
}
