class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int st = 0;
        int end = n - 1;

        while (st <= end) {
            int mid = (st + end) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] >= nums[st]) { // right sortd
                if (target <= nums[mid] && target >= nums[st]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }

            } else {
                if (target <= nums[end] && target >= nums[mid]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}