public class CombinationSumII {
  import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        TargetSum2(0, candidates, new ArrayList<>(), res, target);
        return res;
    }
    
    public static void TargetSum2(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res, int target) {
        // Base case
        if (target == 0) {
            res.add(new ArrayList(curr));
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {

            // Skip duplicates
            if (  (i == idx || nums[i] != nums[i - 1]) && nums[i] <= target) {
                 curr.add(nums[i]); // Include current number
            // Recur with next index and reduced target
            TargetSum2(i + 1, nums, curr, res, target - nums[i]);
            curr.remove(curr.size() - 1); // Backtrack
            }
            
        
        }
    }
}

}
