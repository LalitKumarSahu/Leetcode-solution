public class Check if the array is sorted {
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
     // m-2 by using 2 pointer approach
     ArrayList<Integer> removeDuplicates(int[] arr) {
       int n = arr.length;
       int i = 0;
       for(int j = 1; j<n; j++){
           if(arr[j] != arr[i]){
               arr[i+1] = arr[j];
               i++;
           }
       }
        // Now arr[0..i] contains unique elements
       ArrayList<Integer>res = new ArrayList<>();
       for(int k= 0; k<=i; k++){
           res.add(arr[k]);
       }
       return res;
       
}

  
}
