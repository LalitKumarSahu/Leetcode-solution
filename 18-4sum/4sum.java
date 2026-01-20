

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int li = j + 1;
                int ri = n - 1;

                while (li < ri) {
                    long sum = (long) nums[i] + nums[j] + nums[li] + nums[ri];

                    if (sum < target) {
                        li++;
                    } else if (sum > target) {
                        ri--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[li], nums[ri]));

                        li++;
                        ri--;

                        // skip duplicate li
                        while (li < ri && nums[li] == nums[li - 1]) li++;
                        // skip duplicate ri
                        while (li < ri && nums[ri] == nums[ri + 1]) ri--;
                    }
                }
            }
        }
        return res;
    }
}
