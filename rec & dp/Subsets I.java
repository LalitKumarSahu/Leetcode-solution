public class Subsets I {
  class Solution {
    public List<Integer> subsetSums(int[] nums) {
         List<Integer> subsetSums = new ArrayList<>();
         int N = nums.length;
         fcn(nums, 0, 0, N, subsetSums);
         Collections.sort(subsetSums);
         return subsetSums;
    }
    public void fcn(int nums[], int idx, int sum, int N, List<Integer> subsetSums){
      if(idx == N){
        subsetSums.add(sum);
        return;
      }
      // pick
      fcn(nums, idx+1, sum + nums[idx], N, subsetSums);

      // no pick
      fcn(nums, idx+1, sum, N, subsetSums);
    }
}
}

/*
[]        → sum = 0
[1]       → sum = 1
[2]       → sum = 2
[1, 2]    → sum = 3
o/p = [0, 1, 2, 3]

 */
