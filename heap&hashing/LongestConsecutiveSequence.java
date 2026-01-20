import java.util.HashSet;

public class LongestConsecutiveSequence {
  class Solution {
    public int longestConsecutive(int[] nums) {

     // step 1 : add into the set for removed duplicate
      HashSet<Integer>set = new HashSet<>();
      for(int num : nums){
        set.add(num);
      }

      // step 2 : iterate into set 
      
        int longest = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
            int currNum = num;
            int count = 1;
            
            while(set.contains(currNum + 1)){
                currNum++;
                count++;
            }
            longest = Math.max(longest, count);
        }
    }
    return longest;

        
    }
}
}
