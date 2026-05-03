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
}
