class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieve(right);
        
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        int[] ans = {-1, -1};
        
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prev == -1) {
                    prev = i;
               } else{
                   int diff = i - prev;
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans[0] = prev;
                        ans[1] = i;
                    }
                    prev = i; // minDiff agr nhi mil rha hai fir bhi prev to update hota rhega
               
               }
            }
        }
        
        return ans;
    }
    
    private boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) { //2*2 = 4, 6, 8
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
