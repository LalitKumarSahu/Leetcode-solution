import java.util.*;

public class Array {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer>curr = new ArrayList<>();
    boolean[] vis = new boolean[nums.length];
    permuteHelper(nums, vis, curr, res);
    return res;
  }

  private void permuteHelper(int[] nums, boolean[] vis, List<Integer> curr, List<List<Integer>> res) {
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

// method 2: swapping elements in the array itself
public class Array {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    permuteHelper(nums, 0, res);
    return res;
  }

  private void permuteHelper(int[] nums, int idx, List<List<Integer>> res) {
    if (idx == nums.length) {
      List<Integer> curr = new ArrayList<>();
      for (int num : nums) {
        curr.add(num);
      }
      res.add(curr);
      return;
    }

    for (int i = idx; i < nums.length; i++) {
      swap(nums, idx, i);
      permuteHelper(nums, idx + 1, res);
      swap(nums, idx, i); // backtrack
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  
}