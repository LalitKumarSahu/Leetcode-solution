public class RodCutting {
  //price[] = [1, 5, 8, 9, 10, 17, 17, 20] , N = 8
//first cut rod of length 2 , 2 idx ka price = 5
//and second cut the rod of length 6, 6th idx ka price = 17
// o/p = 5 + 17 = 22
// it is also infinite supply 1 length ka 8 bar kat sakte hai
class Solution {
    public int cutRod(int[] price) {
        int N = price.length; // N is the length of rod
        return rec(N, N-1, price);
    }
    public int rec(int N, int idx, int price[]){
        // base case : length of rod is one
        if(idx == 0){
            return N * price[idx];
        }
        int pick = 0;
        int currLen = idx+1;
        if(N >= currLen){
            pick = price[idx] + rec(N-currLen, idx, price);
        }
        int noPick = 0 + rec(N, idx-1, price);
        
        return Math.max(pick, noPick);
        
    }
}
class Solution2 {
    public int cutRod(int[] price) {
        int N = price.length; // N is the length of rod
        int dp[][] = new int[N][N+1];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N+1; j++){
                dp[i][j] = -1;
            }
        }
        return rec(N, N-1, price, dp);
    }
    public int rec(int N, int idx, int price[], int dp[][]){
        // base case : length of rod is one
        if(idx == 0){
            dp[idx][N] = N * price[idx];
            return N * price[idx];
        }
        if(dp[idx][N] != -1){
            return dp[idx][N];
        }
        int pick = 0;
        int currLen = idx+1;
        if(N >= currLen){
            pick = price[idx] + rec(N-currLen, idx, price,dp);
        }
        int noPick = 0 + rec(N, idx-1, price,dp);
        
        dp[idx][N] =  Math.max(pick, noPick);
        return dp[idx][N];
        
    }
}
// m-3 bottom up approach
class Solution3 {
    public int cutRod(int[] price) {
        int N = price.length; // N is the length of rod
        int dp[][] = new int[N][N+1];
        
        for(int r = 0; r < N+1; r++){
            dp[0][r] = r * price[0];
        }
        for(int i = 1; i<N; i++){
            for(int j = 0; j<N+1; j++){
                 int pick = 0;
                int currLen = i+1;
                if(j >= currLen){
                    pick = price[i] + dp[i][j - currLen];//rec(j-currLen, i, price,dp);
                }
                int noPick = 0 + dp[i-1][j];//rec(j, i-1, price,dp);
                
                dp[i][j] =  Math.max(pick, noPick);
            }
        }
        return dp[N-1][N];
        
    }
   
}
}
