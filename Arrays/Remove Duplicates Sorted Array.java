public class Remove Duplicates Sorted Array {
  class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer>res = new ArrayList<>();
        HashSet<Integer>set = new HashSet<>();
        for(int num : arr){
            if(!set.contains(num)){
                res.add(num);
            }
            set.add(num);
        }
      return res;
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

}
