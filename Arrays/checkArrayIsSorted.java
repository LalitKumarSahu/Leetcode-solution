public class checkArrayIsSorted {
  class Solution {
    public boolean isSorted(int[] arr) {
        int n = arr.length;
        
        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i - 1]){
                return false;  // ek pair bhi decreasing mila → not sorted
            }
        }
        
        return true; // kahin bhi decreasing pair nahi mila → sorted
    }
}

}
