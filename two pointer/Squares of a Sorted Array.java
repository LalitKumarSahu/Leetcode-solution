// m-1
import java.util.*;
public class Squares of a Sorted Array {
  class Solution1 {
    public int[] sortedSquares1(int[] nums) {

        int n = nums.length;

        for(int i = 0; i<n; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
}
