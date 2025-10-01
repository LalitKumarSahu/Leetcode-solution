
class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {
        // Your code here
        int n = arr.length;
        
        // step:1-find pivot elm
        int pivot = 0;
        for(int i = 0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                pivot = i+1;
                break;
            }
        }
        // step:2-left = smaller elm, right = largest elm
        int l = pivot;
        int r = (pivot - 1 + n)%n;
        
        while(l != r){
            int sum = arr[l] + arr[r];
            if(sum == target) return true;
            if(sum < target){
                l = (l+1)%n;
            }else{
                r = (n+r-1)%n;
            }
        }
        return false;
    }
}
