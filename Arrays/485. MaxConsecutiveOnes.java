public class 485. MaxConsecutiveOnes {
  class Solution {
    public int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n; i++){
          
            if(nums[i] == 1){
                count++;
            }else { //  nums[i] = 0
                if(max < count){
                    max = count;
                }
                count = 0; 
            }
            if(max < count){
              max = count;
            }

        }
        return max;
        
    }
      public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n; i++){
          
            if(nums[i] == 1){
                count++;
                max = Math.max(max, count);
            }else { //  nums[i] = 0
               count = 0;

        } 
       
    }
     return max;
 }
}
  
}
