import java.util.HashMap;

public class longestSubarrayWithSumK {
  class Solution {
    
    //Brute force-Genrate all subArray
    public int longestSubarray(int[] arr, int k) {

        int n = arr.length;
        int maxLen = 0;

        // starting point
        for(int i = 0; i < n; i++) {

            // ending point
            for(int j = i; j < n; j++) {

                int sum = 0;

                // calculate sum of subarray from i to j
                for(int a = i; a <= j; a++) {
                    sum += arr[a];
                }

                // check if subarray sum equals k
                if(sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
    
     //Brute force-O(N^2)-Genrate all subArray
    public int longestSubarray2(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;

        // starting point
        for(int i = 0; i < n; i++) {
            int sum = 0;

            // ending point
            for(int j = i; j < n; j++) {
                sum += arr[j]; // running sum

                if(sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
    
 public int longestSubarray3(int[] arr, int k) {
    int n = arr.length;
    int maxLen = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1); // important for sum == k

    for (int i = 0; i < n; i++) {
        sum += arr[i];

        // Case 1: sum itself equals k
        if (sum == k) {
            maxLen = Math.max(maxLen, i + 1);
        }

        // Case 2: check if prefix sum - k exists
        int rem = sum - k;
        if (map.containsKey(rem)) {
            int oldIndex = map.get(rem);
            maxLen = Math.max(maxLen, i - oldIndex);
        }

        // store prefix sum only if not stored before
        if (!map.containsKey(sum)) {
            map.put(sum, i);
        }
    }

    return maxLen;
}

    //m-2 optimal soln this method only for postive arr
  public int longestSubarray4(int[] arr, int k) {
    int n = arr.length;
    int left = 0, sum = 0, maxLen = 0;

    for (int right = 0; right < n; right++) {
        
        sum += arr[right];   // expand window

        // shrink window
        while (left <= right && sum > k) {
            sum -= arr[left];
            left++;
        }

        // check sum
        if (sum == k) {
            maxLen = Math.max(maxLen, right - left + 1);
        }
    }

    return maxLen;
}

}

}
