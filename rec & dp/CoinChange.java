class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = rec(coins, amount, n-1);
        return ans >= 1e9 ? -1 : ans;
        
    }
    public int rec(int[] coins, int amount, int idx){
        if(idx == 0){
            if(amount % coins[idx] == 0){  // eg: amount = 6, coins = 1 => 6 % 1 = 0
                return amount / coins[idx]; // 6/1 = 6=> 1,1,1,1,1,1
            }
            return (int)(1e9);
        }
        int pick = (int)(1e9);
        if(amount >= coins[idx]){
            pick = 1 + rec(coins, amount - coins[idx], idx);
        }
        int noPick = rec(coins, amount, idx-1);

        return Math.min(pick, noPick);
    }
}