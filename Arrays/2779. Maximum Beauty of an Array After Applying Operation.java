class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1) return 1;

        // find max element
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // create count array of size max+1
        int count[] = new int[max + 1];

        // insert count into range array
        for (int num : nums) {
            count[Math.max(num - k, 0)]++;
            count[Math.min(num + k + 1, max)]--; // clamp end index at max
        }

        // find max prefix sum
        int sum = 0, maxSub = 0;
        for (int c : count) {
            sum += c;
            maxSub = Math.max(maxSub, sum);
        }

        return maxSub;
    }
}