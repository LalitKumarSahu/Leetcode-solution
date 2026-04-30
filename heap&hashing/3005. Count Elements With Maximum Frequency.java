import java.util.*;
public class 3005. Count Elements With Maximum Frequency {
  //m-1 store into map
// iterate map and find max freq
//iterate map and jo max freq ke equal hai use add kar do

// m-2 create a 100 size arr
// and nums[i]++; and sort them
// iterate karnge last se agar equal hai to add nhi to break

// m-1 
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find max frequency
        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Step 3: Count elements having max frequency
        int result = 0;
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                result += freq;
            }
        }

        return result;
    }
}
}
