import java.util.*; // Collections required

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num1 : a) {
            for (int num2 : b) {
                pq.add(num1 + num2);
                if (pq.size() > k) pq.poll();
            }
        }

        while (!pq.isEmpty()) list.add(pq.poll()); // now list is ascending
        Collections.reverse(list);                  // make it descending
        return list;
    }
}
