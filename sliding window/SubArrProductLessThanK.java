

public class SubArrProductLessThanK {
  class Solution {
    // tc:O(2N)
    public int numSubarrayProductLessThanAtmostK(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int count = 0;
        int prod = 1;

        for(int end = 0; end <  n; end++){
            // exp
            prod *= nums[end];

            while(start <= end && prod >= k){
                prod = prod/nums[start];
                start++;
            }
            count += (end-start+1);
        }
        return count;
        
    }
      public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0; // 1 she chota koi subarray ban hi nhi payega
        return numSubarrayProductLessThanAtmostK(nums, k);
        
    }
}
}
