import java.util.*;
public class Subarrays with given sum {
  class Solution {
    
    // brute force to better Approach
    public static int subArraySum(int[] arr, int k) {
     int n = arr.length;
     int count = 0;
     for(int i = 0; i<n; i++){
         int sum = 0;
         for(int j = i; j<n; j++){
             sum += arr[j];
             if(sum == k){
                 count++;
                
             }
         }
     }
     return count;
    }
    
    // optimal Approach
    public static int subArraySum2(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int prefixSum = 0;
    
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // very important
    
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
    
            // check if (prefixSum - k) exists
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
    
            // store/update the prefixSum count
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
    
        return count;
}

}

}
