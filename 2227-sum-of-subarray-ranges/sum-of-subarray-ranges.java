// class Solution {
//     public long subArrayRanges(int[] nums) {
//         int n = nums.length;
//         long ans = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int min = Integer.MAX_VALUE;
//                 int max = Integer.MIN_VALUE;

//                 for (int k = i; k <= j; k++) {
//                     min = Math.min(min, nums[k]);
//                     max = Math.max(max, nums[k]);
//                 }

//                 ans += (max - min);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);
                    ans += (max - min);
            }
        }
        return ans;
    }
}

