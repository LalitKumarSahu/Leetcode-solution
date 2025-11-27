import java.util.*;
public class CountSubarraysWithGivenXOR {
  class Solution {
    // brute and better by genrating subArr and cal xor == k -> count++ return count
    
    // optimal soln by using HashMap , x = xor ^ k
    public long subarrayXor(int arr[], int k) {
        int n = arr.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0, 1);
        int xor = 0;
        int count = 0;
        for(int num : arr){
            xor = xor ^ num;
            int x = xor ^ k;
            if(map.containsKey(x)){
                count += map.get(x);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
        
    }
}
}
