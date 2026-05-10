class Solution {
    public int subsetXORSum(int[] nums) {
        return findXorTotal(nums, 0, 0);
    }
    public int findXorTotal(int nums[], int idx, int xor){
        if(idx == nums.length) return xor;

        int pick = findXorTotal(nums, idx+1, xor ^ nums[idx]);
        int noPick = findXorTotal(nums, idx+1, xor); // jo value upar se aa rhi hai vhi le rhe hai

        return pick + noPick;

    }
}