class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currPSum = 0; // for max subarray sum
        int currNSum = 0; // for min subarray sum

        for(int num : nums){
            // for max subarray sum (Kadane's)
            currPSum += num;
            if(currPSum < 0){
                currPSum = 0;
            }
            maxSum = Math.max(maxSum, currPSum);

            // for min subarray sum (reverse Kadane's)
            currNSum += num;
            if(currNSum > 0){
                currNSum = 0;   // ✅ yaha fix kiya
            }
            minSum = Math.min(minSum, currNSum);
        }
        return Math.max(maxSum, Math.abs(minSum));
    }
}
