class Solution {
    public int minPatches(int[] nums, int n) {
        long sumFormed = 0;
        long expectedSum = 1;
        int minPatch = 0;
        int i = 0;
        int m = nums.length;

        while (sumFormed < n) {

            if (i < m && nums[i] <= expectedSum) {
                // use array element
                sumFormed += nums[i];
                i++;
            } else {
                // add patch
                minPatch++;
                sumFormed += expectedSum;
            }

            expectedSum = sumFormed + 1;
        }

        return minPatch;
    }
}