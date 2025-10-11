// User function Template for Java

class Solution {
    long countTriplets(int n, int target, long arr[]) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        long count = 0;  // total triplet count

        // Step 2: Fix one element and use two-pointer for rest
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (sum < target) {
                    // If sum < target, all pairs between left and right are valid
                    count += (right - left);
                    left++;
                } else {
                    // If sum >= target, decrease right
                    right--;
                }
            }
        }

        return count;
    }
}
