class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int st = nums[i];
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            int end = nums[i]; 

            if (st == end) {
                res.add(st + "");
            } else {
                res.add(st + "->" + end);
            }
            i++;
        }
        return res;
    }
}