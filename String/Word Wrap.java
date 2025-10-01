
class Solution {
    public int solveWordWrap(int[] arr, int k) {
        // Code here
        return helper(1, arr[0], arr, k);
    }
    public int helper(int curr, int spaces, int arr[], int k){
        
        // last elm ke liye space nhi find karna hai
        if(curr == arr.length){
            return 0;
        }
        // continue on same line
        int a = Integer.MAX_VALUE;
        int newSpaces = spaces + 1 + arr[curr];
        if(newSpaces <= k){
            a = helper(curr+1, newSpaces, arr, k);
        }
        // start from the next line
        int b = helper(curr+1, arr[curr], arr, k) + (k-spaces) * (k-spaces);
        return Math.min(a, b);
    }
}

// by using memoization
class Solution {
    public int solveWordWrap(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, arr[0], arr, k, dp);
    }

    public int helper(int curr, int spaces, int[] arr, int k, int[][] dp) {
        // last word (no extra cost for last line)
        if(curr == arr.length - 1) {
            return 0;
        }

        if(dp[curr][spaces] != -1) return dp[curr][spaces];

        // Option 1: continue on the same line
        int a = Integer.MAX_VALUE;
        int newSpaces = spaces + 1 + arr[curr + 1]; // add next word with space
        if(newSpaces <= k) {
            a = helper(curr + 1, newSpaces, arr, k, dp);
        }

        // Option 2: break line here
        int extra = k - spaces;
        int b = (extra * extra) + helper(curr + 1, arr[curr + 1], arr, k, dp);

        return dp[curr][spaces] = Math.min(a, b);
    }
}
