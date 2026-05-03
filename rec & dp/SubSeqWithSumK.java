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
}
