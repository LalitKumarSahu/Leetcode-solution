

// m-3
class Solution {
    public int majorityElement(int[] nums) {
       int n = nums.length;
       int candidate = nums[0];
       int vote = 1;

       for(int i = 1; i<n; i++){
         if(vote == 0){
            candidate = nums[i];
            vote = 1;
         }else if(candidate == nums[i]){
            vote++;
         }else{
            vote--;
         }
       }
       return candidate;
    }
}
