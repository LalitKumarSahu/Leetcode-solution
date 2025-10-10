// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int n = arr.length;
        
        for(int i = 0; i<n; i++){
            if(arr[i] >= x){
                return i;
            }
        }
        return -1;
    }
}


class Solution {
    public int findCeil(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ceilIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                // possible answer, but try to find earlier one
                ceilIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceilIndex; // -1 if no element >= x
    }
}
