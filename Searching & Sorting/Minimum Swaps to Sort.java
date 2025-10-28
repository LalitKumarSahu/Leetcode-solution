import java.util.*;

class Solution {
    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[]) {
        int N = arr.length;

        // Step 1: Create an array of pairs (value, original index)
        Pair[] vec = new Pair[N];
        for (int i = 0; i < N; i++) {
            vec[i] = new Pair(arr[i], i);
        }

        // Step 2: Sort pairs by value
        Arrays.sort(vec, (a, b) -> a.val - b.val);

        // Step 3: Count swaps
        int swaps = 0;
        for (int i = 0; i < N; i++) {
            // Already in correct position
            if (vec[i].idx == i)
                continue;

            // Otherwise, swap with the correct position
            swaps++;
            Pair temp = vec[i];
            vec[i] = vec[temp.idx];
            vec[temp.idx] = temp;

            // Decrement i to recheck the current index after swap
            i--;
        }

        return swaps;
    }

    // ✅ Example to test
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 5, 4, 3, 2};
        System.out.println(s.minSwaps(arr)); // Output: 2
    }
}
