//Time: O(n)-using map
//Space: O(n) (extra space for map)
import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Iterate using keySet
        for (Integer key : freq.keySet()) {
            if (freq.get(key) == 2) {
                result.add(key);
            }
        }

        return result;
    }
}

//tc:O(N), sc:O(1) using pop
class Solution2 {
    public List<Integer> findDuplicates(int[] nums) {
       
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            int element = Math.abs(nums[i]);
            int seat = element - 1;
            if(nums[seat] < 0){
                result.add(element);
            }else{
                nums[seat] = -nums[seat];
            }
        }
       

        return result;
    }
}