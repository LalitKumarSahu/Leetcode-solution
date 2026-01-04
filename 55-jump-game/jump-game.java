class Solution { 
    public boolean canJump(int[] nums) {
        int currMax = 0;  // The farthest index we can reach

        for (int i = 0; i < nums.length; i++) {
            if (i > currMax) return false; // If we can't reach index 'i', return false

            currMax = Math.max(currMax, i + nums[i]); // Update max reachable index

            if (currMax >= nums.length - 1) return true; // If we can reach the last index, return true
        }
        return false; // If loop completes, return false
    }
}
