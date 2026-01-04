// class Solution {
//     public int jump(int[] nums) {
//         return fn(0, nums);
//     }

//     public int fn(int idx, int[] nums) {
//         int n = nums.length;

//         if (idx >= n - 1) return 0;

//         int min = Integer.MAX_VALUE;

//         for (int i = 1; i <= nums[idx]; i++) {
//             if (idx + i < n) {
//                 int res = fn(idx + i, nums);
//                 if (res != Integer.MAX_VALUE) {
//                     min = Math.min(min, 1 + res);
//                 }
//             }
//         }
//         return min;
//     }
// }

// m-2 by O(N)
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }
}
