// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int ans = rec(coins, amount, n-1);
//         return ans >= 1e9 ? -1 : ans;
        
//     }
//     public int rec(int[] coins, int amount, int idx){
//         if(idx == 0){
//             if(amount % coins[idx] == 0){  // eg: amount = 6, coins = 1 => 6 % 1 = 0
//                 return amount / coins[idx]; // 6/1 = 6=> 1,1,1,1,1,1
//             }
//             return (int)(1e9);
//         }
//         int pick = (int)(1e9);
//         if(amount >= coins[idx]){
//             pick = 1 + rec(coins, amount - coins[idx], idx);
//         }
//         int noPick = rec(coins, amount, idx-1);

//         return Math.min(pick, noPick);
//     }
// }

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<amount+1; j++){
                dp[i][j] = -1;
            }
        }
        int ans = rec(coins, amount, n-1, dp);
        return ans >= 1e9 ? -1 : ans;
        
    }
    public int rec(int[] coins, int amount, int idx, int dp[][]){
        if(idx == 0){
            if(amount % coins[idx] == 0){  // eg: amount = 6, coins = 1 => 6 % 1 = 0
                dp[idx][amount] = amount / coins[idx];
                return amount / coins[idx]; // 6/1 = 6=> 1,1,1,1,1,1
            }
            dp[idx][amount] =  (int)(1e9);
            return (int)(1e9);
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int pick = (int)(1e9);
        if(amount >= coins[idx]){
            pick = 1 + rec(coins, amount - coins[idx], idx, dp);
        }
        int noPick = rec(coins, amount, idx-1, dp);

        dp[idx][amount] =  Math.min(pick, noPick);
        return dp[idx][amount];
    }
}