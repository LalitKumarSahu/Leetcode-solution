import java.util.*;
public class 3 sum {
  class Solution {
    // brute force
    public List<List<Integer>> threeSum1(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        Collections.sort(temp); // safe sort
                        set.add(temp);          // duplicates removed
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
    }

   // better soln
    public List<List<Integer>> threeSum2(int[] nums) {
    int n = nums.length;
    Set<List<Integer>> ans = new HashSet<>();

    for (int i = 0; i < n; i++) {

        Set<Integer> hash = new HashSet<>();

        for (int j = i + 1; j < n; j++) {

            int third = -(nums[i] + nums[j]);

            // if third element exists → we found a triplet
            if (hash.contains(third)) {

                List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                Collections.sort(temp);     // to avoid duplicates
                ans.add(temp);              // add triplet set me
            }

            hash.add(nums[j]);  // add j-th value to hashset
        }
    }
    return new ArrayList<>(ans);
 }

 // optimal soln using 2ptr
 public List<List<Integer>> threeSum3(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    int n = nums.length;

    Arrays.sort(nums); // MUST

    for (int i = 0; i < n; i++) {

        if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate i

        int j = i + 1;
        int k = n - 1;

        while (j < k) {

            int sum = nums[i] + nums[j] + nums[k];

            if (sum < 0) {
                j++;
            }
            else if (sum > 0) {
                k--;
            }
            else { 
                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                j++;
                k--;

                // skip duplicate j
                while (j < k && nums[j] == nums[j - 1]) j++;

                // skip duplicate k
                while (j < k && nums[k] == nums[k + 1]) k--;
            }
        }
    }

    return ans;
}

}





