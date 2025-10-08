// brute force
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 0; i<=n-k; i++){
            int maxVal = Integer.MIN_VALUE;
            
            for(int j = i; j<i+k; j++){
                maxVal = Math.max(maxVal, arr[j]);
            }
            list.add(maxVal);
        }
        return list;
    }
}

import java.util.*;

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Step 1: Add first k elements to maxHeap
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        
        // Step 2: First window ka max add karo
        result.add(pq.peek());
        
        // Step 3: Process remaining elements
        for (int i = k; i < n; i++) {
            // Remove element going out of window
            pq.remove(arr[i - k]);
            
            // Add new element
            pq.add(arr[i]);
            
            // Current max
            result.add(pq.peek());
        }
        
        return result;
    }
}
