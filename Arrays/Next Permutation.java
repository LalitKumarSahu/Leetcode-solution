public class Next Permutation {
  class Solution {
    // optimal tc : O(N) + O(N) + O(N) = O(N), sc :O(1)
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int idx = -1;

        // Step 1: Find breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {   
                idx = i;
                break;
            }
        }

        // If no breakpoint → last permutation → reverse to first
        if (idx == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Step 2: Find element just greater than arr[idx] from right end
        for (int i = n - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;      
            }
        }

        // Step 3: Reverse the suffix
        reverse(arr, idx + 1, n - 1);
    }

    void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}

}
