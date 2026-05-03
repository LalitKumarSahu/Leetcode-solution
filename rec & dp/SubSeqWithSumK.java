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
}
