import java.util.HashMap;

public class majorityElm {
  class Solution {
    public int majorityElement(int[] nums) {
    HashMap<Integer, Integer>map = new HashMap<>();
        int n = nums.length;
        // count the freq of each element
        for(int i=0; i<n; i++){
          map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int elm = 0;
        for(Integer key : map.keySet()){ // freq is greater than n/2 return key(elm)
            if(map.get(key) > n/2){
               elm = key;
            }
        }
        return elm;
    }
}
// by single loop
class Solution2 {
    public int majorityElement(int[] nums) {
    HashMap<Integer, Integer>map = new HashMap<>();
        int n = nums.length;
        // count the freq of each element
        for(int i=0; i<n; i++){
          int count = map.getOrDefault(nums[i], 0) + 1;
          if(count > n/2){
            return nums[i];
          }
         map.put(nums[i], count);

        }
       return -1;
    }
}


}
