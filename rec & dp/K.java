import java.util.ArrayList;
import java.util.List;

public class K-thPermutationSequence {
  public void permuteHelper(int[] nums, boolean[] vis, List<Integer> curr, List<List<Integer>> res) {
    if (curr.size() == nums.length) {
        res.add(new ArrayList<>(curr));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (vis[i]) continue;

        vis[i] = true;
        curr.add(nums[i]);
        permuteHelper(nums, vis, curr, res);
        curr.remove(curr.size() - 1);
        vis[i] = false;
    }
}

}
