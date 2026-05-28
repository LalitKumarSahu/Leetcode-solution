import java.util.TreeMap;

public class continuousSubarray {
  class Solution {
    // aise subArray ka count batana hai jisme diff hai subarray me 0 se 2 ho
    // if the length of the subarray is 1 to ye bhi hoga 
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer,Integer>map = new TreeMap<>();
         
         int start = 0;
         int end = 0;
         int n = nums.length;
        
         long count = 0;

         while(end < n){
          // expansion
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            // max = map.lastEntry().getKey();
            // min = map.firstEntry().getKey();
            // int diff = max - min;

            // shrinking phase
            while(map.lastEntry().getKey() - map.firstEntry().getKey() > 2 ){
            map.put(nums[start], map.getOrDefault(nums[start], 0) - 1);
            if(map.get(nums[start]) == 0){
                map.remove(nums[start]);
            }
            start++;
          }
            count += (end-start + 1);
            end++;
         }
        return count;
        
    }
}
// m-2 linear time without tree map
class Solution {
    
    public long continuousSubarrays(int[] nums) {
        
         
         int start = 0;
         int end = 0;
          int n = nums.length;
         long count = 0;
         int currMax = Integer.MIN_VALUE;
         int currMin = Integer.MAX_VALUE;

         while(end < n){
             currMax = Math.max(currMax, nums[end]);
             currMin = Math.min(currMin, nums[end]);

             if(currMax - currMin > 2){
                start = end;
                currMax = nums[end];
                currMin = nums[end];

                while(start >= 0 && Math.abs(nums[start-1] - nums[end]) <= 2){
                    start--;
                    currMax = Math.max(currMax, nums[start]);
                    currMin = Math.min(currMin, nums[start]);
                }
             }
           
          
            count += (end-start + 1);
            end++;
         }
        return count;
        
    }
}
}
