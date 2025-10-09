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


class Solution {
    class Pair {
        int i, j, sum;
        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;

        // Max Heap (largest sum on top)
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.sum - x.sum);
        HashSet<String> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Start from last indices (largest elements)
        pq.add(new Pair(n - 1, n - 1, a[n - 1] + b[n - 1]));
        set.add((n - 1) + "," + (n - 1));

        while (k-- > 0 && !pq.isEmpty()) {
            Pair curr = pq.poll();
            res.add(curr.sum);
            int i = curr.i;
            int j = curr.j;

            // Move one step back in array a
            if (i - 1 >= 0 && !set.contains((i - 1) + "," + j)) {
                pq.add(new Pair(i - 1, j, a[i - 1] + b[j]));
                set.add((i - 1) + "," + j);
            }

            // Move one step back in array b
            if (j - 1 >= 0 && !set.contains(i + "," + (j - 1))) {
                pq.add(new Pair(i, j - 1, a[i] + b[j - 1]));
                set.add(i + "," + (j - 1));
            }
        }

        return res;
    }
}
