import java.util.ArrayList;
import java.util.List;

public enum CombinationSum {
  class Solution {
    //by using pick or no pick
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
     List<Integer> curr = new ArrayList<>();
     rec(candidates, target, 0, curr, res);
     return res;

    }
    public static void rec(int[] candidates, int target,int idx,List<Integer> curr, List<List<Integer>>res){
          // base case
          if(idx == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(curr));

            }
            return;
          }

          //include
          if(candidates[idx] <= target){
            curr.add(candidates[idx]);
            rec(candidates, target-candidates[idx], idx, curr, res);
            // backtrack
            curr.remove(curr.size()-1);
          }
          //exclude
           rec(candidates, target, idx+1, curr, res);
    }
}
}
