import java.util.Arrays;
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);  
        // reverse order mein check karenge
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i-1] + nums[i-2] > nums[i]) {  // a + b > c
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
}
