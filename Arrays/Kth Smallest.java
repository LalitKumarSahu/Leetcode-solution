// User function Template for Java

import java.util.*;

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Max-Heap to store k smallest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            pq.add(num);

            // Keep only k elements in heap
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Top of max-heap is kth smallest
        return pq.peek();
    }
}
