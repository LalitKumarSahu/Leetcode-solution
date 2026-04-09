public class 2364. Count Number of Bad Pairs {
  class Solution {
    public long countBadPairs(int[] nums) {

        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(i < j && j-i != nums[j] - nums[i]){
                    count++;
                }
            }
        }
        return count; 
        
    }
}
}
