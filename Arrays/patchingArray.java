public class patchingArray {
  class Solution {
    public int minPatches(int[] nums, int n) {
        
        long sumFormed = 0;
        long expectedSum = 1;// ye hai 1 to n
        int minPatches = 0;
        int i= 0;
        int m = nums.length;
        while(sumFormed < n){
            // matlab vha tak ban gaya hai 
            if(sumFormed >= expectedSum){
                expectedSum = sumFormed + 1; // check for the next value
            }else{
                // expected sum > sumformed
                // to mai nums[i] vale elm ko include kar sakta hun
              if(i<m && nums[i] <= expectedSum){
                sumFormed += nums[i];
                i++;
              }else{
                 minPatches++;
                 sumFormed += expectedSum;
              }
            }
        }
        return minPatches;
    }
}

// m-2
class Solution {
    public int minPatches(int[] nums, int n) {
         long sumFormed = 0;
         long expectedSum = 1;
         int minPatches = 0;
         int i = 0;
         int m = nums.length;

         while( sumFormed < n){
            if(sumFormed >= expectedSum){
              expectedSum = sumFormed + 1;
            }else{
                if(i<m && nums[i] <= expectedSum){
                    sumFormed += nums[i];
                    i++;
                }else{
                    minPatches++;
                    sumFormed += expectedSum;
                }
            }
         }
         return minPatches;

    }
}
}
