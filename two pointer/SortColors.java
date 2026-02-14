public class SortColors {
  class Solution {
    // start se 0 dalenge aur end se 2, 1 hoga to skip 
    // start se end 1 dal denge
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                i++;
                start++;
            } else if (nums[i] == 2) {
                swap(nums, i, end);
                end--;  // Don't increment `i`, as the new value at `i` needs to be checked
                
            } else { // nums[i] == 1
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

}
