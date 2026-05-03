public class SubSeqWithSumK {
  class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        int n = arr.length;
        return rec(arr, k, n-1);
    }
    public static boolean rec(int arr[], int k, int idx){
        if(k == 0){
            return true;
        }
        if(idx == 0){
            if(arr[idx] == k) return true;
            return false;
        }
        boolean pick = false;
        if(arr[idx] <= k){
            pick = rec(arr, k - arr[idx], idx-1);
            if(pick){
                return true;
            }
        }
        boolean noPick = rec(arr, k, idx-1);
        return noPick;
    }
}
// using top down approach
class Solution2 {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][k+1]; //(idx, target)
        return rec(arr, k, n-1, dp);
    }
    //0 -> not visited
    //1 -> true
    //2 -> false
    public static boolean rec(int arr[], int k, int idx, int dp[][]){
        if(k == 0){
            dp[idx][k] = 1;
            return true;
        }
        if(idx == 0){
            if(arr[idx] == k){
            dp[idx][k] = 1;
            return true;
            }
            dp[idx][k] = 2;
            return false;
            
        }
        if(dp[idx][k] != 0){
            return (dp[idx][k] == 1);
        }
        
        boolean pick = false;
        if(arr[idx] <= k){
            pick = rec(arr, k - arr[idx], idx-1, dp);
            if(pick){
                 dp[idx][k] = 1;
                return true;
            }
        }
        boolean noPick = rec(arr, k, idx-1, dp);
         dp[idx][k] = (noPick == true)?1:2;
        return noPick;
    }
}
// using bottom to top

class Solution3 {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][k+1]; //(idx, target)
        // base case : k == 0 hai to koi bhi idx hot true hoga
        for(int i = 0; i<n; i++){
            dp[i][0] = 1;
        }
        // idx == 0 hai to target equal to arr[0] to true otherwise false
        for(int t = 1; t <= k; t++){
            if(t == arr[0]){
                dp[0][t] = 1;
            }else{
                dp[0][t] = 2;
            }
        }
        for(int i = 1; i<n; i++){
            for(int j = 1; j<=k; j++){
                
            int pick = 2;
            if(arr[i] <= j){
                pick = dp[i-1][j - arr[i]];//rec(arr, j - arr[i], i-1, dp);
                if(pick == 1){
                     dp[i][j] = 1;
                    continue;
                }
            }
            int noPick = dp[i-1][j];//rec(arr, j, i-1, dp);
             dp[i][j] = noPick;
            }
        }
        return (dp[n-1][k] == 1);
    }
}
// using space optimization

class Solution4 {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        int n = arr.length;
        int prev[] = new int[k+1];          
        // base case : k == 0 hai to koi bhi idx hot true hoga
        // for(int i = 0; i<n; i++){
        //     dp[i][0] = 1;
        // }
          prev[0] = 1;
        // idx == 0 hai to target equal to arr[0] to true otherwise false
        for(int t = 1; t <= k; t++){
            if(t == arr[0]){
                prev[t] = 1;
            }else{
                prev[t] = 2;
            }
        }
        // dp[i-1] = prev, dp[i] = curr
        for(int i = 1; i<n; i++){
            int curr[] = new int[k+1];
            curr[0] = 1;
            for(int j = 1; j<=k; j++){
                
            int pick = 2;
            if(arr[i] <= j){
                pick = prev[j - arr[i]];//rec(arr, j - arr[i], i-1, dp);
                if(pick == 1){
                     curr[j] = 1;
                    continue;
                }
            }
            int noPick = prev[j];//rec(arr, j, i-1, dp);
             curr[j] = noPick;
            }
            prev = curr;
        }
        return (prev[k] == 1);
    }
}
 
}
