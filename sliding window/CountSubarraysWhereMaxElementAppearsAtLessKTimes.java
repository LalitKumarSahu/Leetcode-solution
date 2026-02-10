import java.util.*;
public class CountSubarraysWhereMaxElementAppearsAtLessKTimes {
  class Solution {
    public int findMax(int nums[]){
     int n = nums.length;
     int max = Integer.MIN_VALUE;

     for(int i = 0; i<n; i++){
        if(max < nums[i]){
            max = nums[i];
        }
     }
     return max;
    }
    public long countSubarrays(int[] nums, int k) {
     int max = findMax(nums);

     int n = nums.length;
     int start = 0;
     int end = 0;
     int maxFreqCount = 0;
     long count = 0;

     while(end < n){
        // exp

        if(nums[end] == max){
            maxFreqCount++;
        }

        // shrining
        while(maxFreqCount == k){
 // ek to start se end tak hoga aur ab jitne honge end ke bad vo bhi hoga isiliye direct nikal liye n - end  se        
            count += (n - end); 
            if(nums[start] == max){
                maxFreqCount--;
            }
            start++;
        }
        end++;
     }
     return count;
       
        
    }
}
}
