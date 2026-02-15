//by using set store the number and iterate i to n , i is not present in set return i is the ans
// sorting and iterate nums[i] != i return i is the ans

// class Solution {
//     public int missingNumber(int[] nums) {
//          int sum = 0;
//          int n = nums.length;
//         for(int i = 0; i<n; i++){
//            sum += nums[i];
//         }
//         int nSum = n*(n+1)/2;
//         int missing = nSum - sum;

//         return missing;
        
//     }
// }

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = n;
        for(int i = 0; i<n; i++){
           x = x ^ nums[i] ^ i;
        }
        return x;
        
    }
}