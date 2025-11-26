public class Maximum Product Subarray {
  class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;

        int prefix = 1, suffix = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            
            // if prefix becomes zero, restart
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[n - 1 - i];

            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }
}

}
