// traped water = (bar ki hight - waterlevel ) * width
// width is same = 1 
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0; // Edge case: Empty array
        
        // Calculate left max boundary
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {  // Fixed: Start from i=1
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Calculate right max boundary
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // Calculate trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
            // width is one keval (wl - bar ki height)
        }
        return trappedWater;
    }
}
