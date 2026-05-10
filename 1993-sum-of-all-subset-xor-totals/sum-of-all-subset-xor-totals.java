// class Solution {
//     public int subsetXORSum(int[] nums) {
//         return findXorTotal(nums, 0, 0);
//     }
//     public int findXorTotal(int nums[], int idx, int xor){
//         if(idx == nums.length) return xor;

//         int pick = findXorTotal(nums, idx+1, xor ^ nums[idx]);
//         int noPick = findXorTotal(nums, idx+1, xor); // jo value upar se aa rhi hai vhi le rhe hai

//         return pick + noPick;

//     }
// }

//----m-2--------------------------->
// number of set bit dekh lo
//5 =0101
//1 = 0001
//6 = 0110
//--or-------->
//0111 and then dive by 2^n/2 = 8/2 = 4
//4*4 + 2*4 + 1 * 4 = 28
//---------------------------------------->
class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        for(int elm : nums){
            totalXor = totalXor | elm;
        }
        return totalXor * (int)Math.pow(2, n-1);
    }
   
}