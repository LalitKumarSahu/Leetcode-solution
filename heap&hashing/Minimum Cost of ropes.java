import java.util.*;

class Solution {
    public static int minCost(int[] arr) {
        // Create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all ropes to the heap
        for (int num : arr) {
            pq.add(num);
        }

        int cost = 0; // total cost

        // Combine ropes until one rope is left
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            cost += sum;

            pq.add(sum);
        }

        return cost;
    }
}
