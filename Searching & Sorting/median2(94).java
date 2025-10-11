import java.util.*;

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> res = new ArrayList<>();   
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : arr) {
            // Step 1: Insert
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            
            // Step 2: Balance heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            
            // Step 3: Find median
            double median;
            if (maxHeap.size() == minHeap.size()) {
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                median = maxHeap.peek();
            }
            
            res.add(median);
        }
        
        return res;
    }
}
