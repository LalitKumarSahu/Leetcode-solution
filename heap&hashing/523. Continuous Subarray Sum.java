//-----------x------------>
//-----z------>--p--------->
// p % k == 0 hai to z % k == x hoga

public class 523. Continuous Subarray Sum {
  class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>hm = new HashMap<>();

        hm.put(0, -1);

        int perfixSum = 0;

        for(int i=0; i<nums.length; i++){
            perfixSum += nums[i];
            int rem = perfixSum%k;

         
            if(hm.containsKey(rem)){
                // check size
                int idx = hm.get(rem);
                if((i-idx) >=2){ // end - start  >= 2
                    return true;
                }
            }else{
                hm.put(rem, i);
            }
        }
        return false;
        
    }
}
}
