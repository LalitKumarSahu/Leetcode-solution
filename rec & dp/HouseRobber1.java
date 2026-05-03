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
}
