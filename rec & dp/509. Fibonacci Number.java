// m-1 by using recursion tc = O(2 ^ N)
import java.util.Arrays;
class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
}

// m-2 by using memoization tc = O(N),sc = O(N) and extra rec stack space

class Solution2 {
    public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(n, dp);
    }
    public int rec(int n, int dp[]){
        if(n <= 1){
            dp[n] = n;
            return dp[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = rec(n-1, dp) + rec(n-2, dp);
        return dp[n];
    }
}

// m-3 by using tabulation tc = O(N) , sc = O(N)

class Solution3 {
    public int fib(int n) {
        if(n <= 1) return n;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int state = 2; state <=n; state++){
            dp[state] = dp[state-1] + dp[state-2];
        }
        return dp[n];
    }
}

// m-4 optimization tc = O(N)
class Solution4 {
    public int fib(int n) {
        if(n <= 1) return n;
        int prev2 = 0;
        int prev1 = 1;
        int ans = 0;

       // f(2) = f(1) + f(0); ans = prev1 + prev2
       // f(3) = f(2) + f(1); prev1 = ans and prev2 = prev1
        
        for(int state = 2; state <=n; state++){
            ans = prev2 + prev1;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}