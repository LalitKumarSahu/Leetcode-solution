import java.util.*;

class Solution {
    static class Pair implements Comparable<Pair> {
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        // min-heap based on frequency
        public int compareTo(Pair p2) {
            return this.count - p2.count;  // smaller frequency has higher priority
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min-heap to keep top k frequent elements
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
            if (pq.size() > k) {
                pq.poll(); // remove least frequent
            }
        }

        // Extract top k elements
        int[] arr = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            arr[i++] = pq.poll().num;
        }

        return arr;
    }
}
