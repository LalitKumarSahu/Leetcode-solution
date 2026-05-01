public class 974. Subarray Sums Divisible by K {
  class Solution {
    public int subarraysDivByK(int[] nums, int k) {
           HashMap<Integer, Integer>hm = new HashMap<>(); // rem and count
           hm.put(0,1);
           int perfixSum = 0;
           int res = 0;

        for(int i=0; i<nums.length; i++){
            perfixSum += nums[i];
            int rem = perfixSum%k;

            if(rem < 0){ // handel negative rem
                rem = rem % k + k;
            }

            if(hm.containsKey(rem)){
              res += hm.get(rem);
               
            }
                hm.put(rem , hm.getOrDefault(rem, 0) + 1);
            
        }
       return res;
    }
}
}
