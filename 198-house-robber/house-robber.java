// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;

//         return rec(nums, n-1);
//     }
//     public int rec(int nums[], int idx){
//         if(idx == 0) return nums[0];

//         if(idx == -1) return 0;

//         int pick = nums[idx] + rec(nums, idx-2);
//         int noPick = 0 + rec(nums, idx-1);

//         return Math.max(pick, noPick);

//     }
// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;
//         int[] dp = new int[n+1];  // shifting logic bcz array can not hold negative idx
//         Arrays.fill(dp, -1);
//         return robUtil(nums, n, dp);
//     } 
//     public int robUtil(int[] nums, int i, int[] dp) {
//          if (i == 1){ // i == 0
//             dp[i] = nums[0];
//             return nums[0];
//         }
//         if (i == 0) {
//             dp[i] = 0;
//             return 0;
//         }
//        if(dp[i] != -1){
//         return dp[i];
//        }
//        int pick = nums[i-1] + robUtil(nums, i-2, dp);
//        int noPick = 0 + robUtil(nums, i-1, dp);

//        dp[i] = Math.max(pick, noPick);
//        return dp[i];
//     }
// }

//m-3 by tabulation
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;
//         int[] dp = new int[n]; // Use n+1 to align with robUtil's index
//          dp[0] = 0;
//          dp[1] = nums[0];
         
//          for(int i = 2; i < n+1; i++ ){
//             int pick = nums[i - 1] + dp[i-2];
//             int noPick = 0 + dp[i-1];
//              dp[i] = Math.max(pick, noPick);
//          }
//          return dp[n];
//     }

// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;
//          int prev2 = 0;
//          int prev1 = nums[0];
//          int ans = 0;
         
//          for(int i = 2; i < n+1; i++ ){
//             int pick = nums[i - 1] + prev2;
//             int noPick = 0 + prev1;
//             ans = Math.max(pick, noPick);
//             prev2 = prev1;
//             prev1 = ans;
//          }
//          return ans;
//     }

// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         return rec(n-1, nums);
//     }
//     public int rec(int idx, int nums[]){
//         if(idx == 0) return nums[0];

//         if(idx == -1) return 0;

//         int pick = nums[idx] + rec(idx-2, nums);
//         int noPick = 0 + rec(idx-1, nums);

//         return Math.max(pick, noPick);

//     }

// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int dp[] = new int[n+1]; // shifting logic
//         Arrays.fill(dp, -1);


//         return rec(n, nums, dp);
//     }
//     public int rec(int idx, int nums[], int dp[]){

//         if(idx == 1) {
//             dp[idx] = nums[0];
//             return nums[0];
//         }

//         if(idx == 0) {
//             dp[idx] = 0;
//             return 0;
//         }

//         int pick = nums[idx-1] + rec(idx-2, nums, dp);
//         int noPick = 0 + rec(idx-1, nums, dp);

//         dp[idx] =  Math.max(pick, noPick);

//         return dp[idx];

//     }

// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int dp[] = new int[n+1]; // shifting logic
//         dp[0] = 0;
//         dp[1] = nums[0];

//         for(int i = 2; i<=n; i++){
//             int pick = nums[i-1] + dp[i-2];
//             int noPick = 0 + dp[i-1];
//             dp[i] = Math.max(pick, noPick);
//         }


//         return dp[n];
//     }
   

// }

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
       
//         int prev2 = 0; //dp[0]
//         int prev1 = nums[0]; // dp[1]
//         int ans = 0;

//         for(int i = 2; i<=n; i++){
//             int pick = nums[i-1] + prev2;
//             int noPick = 0 + prev1;
//             ans = Math.max(pick, noPick);
//             prev2 = prev1;
//             prev1 = ans;
//         }


//         return ans;
//     }
   

// }

// idx = n
//pick = num[idx] + rec(idx-2)
//no pick = 0 + rec(idx-1)
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;

//         return rec(n-1, nums);
       
        
//     }
//     public int rec(int idx, int nums[]){
//         if(idx == 0){
//             return nums[idx];
//         }

//         if(idx == -1) return 0;

//         int pick = nums[idx] + rec(idx-2, nums);
//         int noPick = 0 + rec(idx-1, nums);

//         return Math.max(pick, noPick);

//     }
   

// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n]; 

        Arrays.fill(dp, -1);

        return rec(n-1, nums, dp);
       
        
    }
    public int rec(int idx, int nums[], int dp[]){
        if(idx == 0){
            dp[idx] = nums[0];
            return nums[0];
        }

        if(idx < 0){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = nums[idx] + rec(idx-2, nums, dp);
        int noPick = 0 + rec(idx-1, nums, dp);

        dp[idx] =  Math.max(pick, noPick);
        return dp[idx];

    }
   

}
