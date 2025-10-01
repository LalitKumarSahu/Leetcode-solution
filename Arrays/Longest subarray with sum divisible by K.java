// User function Template for Java

class Solution {
    int longestSubarrayDivK(int[] arr, int k) {
        // Complete the function
        HashMap<Integer, Integer>map = new HashMap<>();
        map.put(0, -1);
        
        long sum = 0; int maxLen = 0;
        
        int n = arr.length;
        for(int i = 0; i<n; i++){
            sum += arr[i];
            // int rem = sum % k;
            
            // // convert -ve rem to +ve
            // if(rem < 0){
            //     rem += k;
            // }
            
              int rem = (int)((sum % k + k) % k); // normalize remainder
            
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }else{
                map.put(rem, i);
            }
        }
        return maxLen;
    }
}
