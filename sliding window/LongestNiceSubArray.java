public class LongestNiceSubArray {
  class Solution {
    // shrinking ke liye xor 
    // expanding ke liye or
    public int longestNiceSubarray(int[] nums) {
        int start = 0;
        int maxLen = 0;
        int bitMask = 0;
        int n = nums.length;

        for (int end = 0; end < n; end++) {
            // Agar overlap bits hain to window shrink karo
            while ((bitMask & nums[end]) != 0) {
                bitMask ^= nums[start];
                start++;
            }
            // Current element ko bitmask me include karo
            bitMask |= nums[end];
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
}
