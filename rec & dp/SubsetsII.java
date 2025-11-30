import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
  class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        Arrays.sort(nums);  // IMPORTANT: duplicate handling

        fcn(nums, 0, curr, res);
        return res;
    }

    public void fcn(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        
        res.add(new ArrayList<>(curr));   // subset add karo (har level)
        
        for (int i = idx; i < nums.length; i++) {
            
            // duplicate skip condition
            if (i != idx && nums[i] == nums[i - 1]) 
                continue;

            curr.add(nums[i]);
            fcn(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}

}
