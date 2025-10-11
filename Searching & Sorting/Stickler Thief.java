class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return rec(arr, n - 1, dp);
    }

    private int rec(int[] nums, int idx, int[] dp) {
        // Base cases
        if (idx == 0)
            return nums[0];
        if (idx < 0)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        // Pick current element
        int pick = nums[idx] + rec(nums, idx - 2, dp);
        // Don't pick current element
        int noPick = rec(nums, idx - 1, dp);

        // Store and return
        return dp[idx] = Math.max(pick, noPick);
    }
}
