import java.util.*;

public class BinarySubarrayWithSum {
  class Solution {
    // pehle jo goal diya hai man lo 2 hai = 0,1,2 sab sab le lenge usme se 0 to 1 minus kar denge 
    // to goal vala hi subarray rhega
    public int numSubarraysWithSumAtmostk(int[] nums, int goal) {
        int n = nums.length;

        int start = 0;
        int sum = 0;
        int count = 0;

        for(int end = 0; end < n; end++){

            // exp
            sum += nums[end];
            
             // shrink
            while(start <= end && sum > goal){
        
                sum -= nums[start];
                start++;
            }
            count += (end-start+1);
        }
        return count;
        
    }
     public int numSubarraysWithSum(int[] nums, int goal) {
  
      return numSubarraysWithSumAtmostk(nums, goal) - numSubarraysWithSumAtmostk(nums, goal-1);
       
        
    }
}
}
