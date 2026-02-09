import java.util.*;
public class 523.continousSubArray {
  class Solution {
    // subarray of size is atLeast 2 and sum is multipl by k
    // multiple ans ho sakte hai lekin koi ek bhi mila to true return kar denge
    //agar koi sum already exist karta hai map me matlab multiple of k exist karta hai
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>hm = new HashMap<>();
        
       //starting vala elm hi ans nikal jaye
        hm.put(0, -1);

        int perfixSum = 0;

        for(int i=0; i<nums.length; i++){
            perfixSum += nums[i];
            int rem = perfixSum%k;

         
            if(hm.containsKey(rem)){
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
