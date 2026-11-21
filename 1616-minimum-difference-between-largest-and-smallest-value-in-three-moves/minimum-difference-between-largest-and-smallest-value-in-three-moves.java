// class Solution {
//     // ------tc-O(NlogN) + o(4)---sc-O(N)----------->
//     public int minDifference(int[] nums) {
//         if(nums.length <= 4){
//             return 0;
//         }
//         Arrays.sort(nums);
//         int n = nums.length;
//         int res = Integer.MAX_VALUE;
//         //case-1(largest three) last ke 3 elm ko last ke 4th ke euqal kar de
//         res = Math.min(res, nums[n-4]-nums[0]);
//         //case-2
//         res = Math.min(res, nums[n-3]-nums[1]);
//         //case-3
//         res = Math.min(res, nums[n-2]-nums[2]);

//         //case-4 (smallest three) start ke 3 elm 4th ke equal kar de
//         res = Math.min(res, nums[n-1]-nums[3]);

//         return res;

//     }
// }

//------------------->
// class Solution {
//     // ------tc-O(NlogN) + o(4)---sc-O(N)----------->
//     public int minDifference(int[] nums) {
//         int n = nums.length;
//         if(n <= 4){
//             return 0;
//         }
//         Arrays.sort(nums);
//         int res = Integer.MAX_VALUE;

//         // case1
//         res = Math.min(res, nums[n-4]-nums[0]);
//          // case2
//         res = Math.min(res, nums[n-3]-nums[1]);
//         // case3
//         res = Math.min(res, nums[n-2]-nums[2]);
//         // case4
//         res = Math.min(res,nums[n-1]-nums[3]);

//         return res;


//     }
// }

class Solution {
    // ------tc-O(NlogN) + o(4)---sc-O(N)----------->
    public int minDifference(int[] nums) {
       int n = nums.length;

       if(n <= 4){
        return 0;
       }
       Arrays.sort(nums);

       int res = Integer.MAX_VALUE;

       res = Math.min(res, nums[n-4] - nums[0]);
       res = Math.min(res, nums[n-3] - nums[1]);
       res = Math.min(res, nums[n-2] - nums[2]);
       res = Math.min(res, nums[n-1] - nums[3]);

       return res;




    }
}
