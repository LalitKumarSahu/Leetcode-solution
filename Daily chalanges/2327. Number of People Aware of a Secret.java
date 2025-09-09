
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long MOD = (long)1e9 + 7;
        long start[] = new long[n+1];
        start[1] = 1; // Day 1
        
        long share = 0;
        for(int day = 2; day <=n; day++){
            if(day - delay > 0){
                share = (share + start[day-delay]) % MOD;
            }
            if(day-forget > 0){
                share = (share - start[day-forget] + MOD) % MOD;
            }
            start[day] = share;

        }
        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            ans = (ans + start[i]) % MOD;
        }
        return (int)ans;
    }
}