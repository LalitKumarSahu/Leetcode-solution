public class 1122. Relative Sort Array {
  class Solution {
    // Time Complexity: O(N + M + K), where
    // N = arr1.length, M = arr2.length, K = max element in arr1
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int max = 0;

        // O(N) - Find maximum element in arr1
        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr1[i]);
        }

        int count[] = new int[max + 1];

        // O(N) - Count frequency of each element in arr1
        for(int i = 0; i < n; i++) {
            int elm = arr1[i];
            count[elm]++;
        }

        int res[] = new int[n];
        int j = 0;

        // O(M + total frequency of elements from arr2 in arr1)
        // Worst case: O(N) if all elements of arr2 are in arr1
        for(int i = 0; i < m; i++) {
            int elm = arr2[i];
            while(count[elm] > 0) {
                res[j] = elm;
                j++;
                count[elm]--;
            }
        }

        // O(K) where K = max element in arr1
        // Remaining elements in ascending order
        for(int i = 0; i < max + 1; i++) {
            while(count[i] > 0) {
                res[j] = i;
                j++;
                count[i]--;
            }
        }

        return res;
    }
}

}
