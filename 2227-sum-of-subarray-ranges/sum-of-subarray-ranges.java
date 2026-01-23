// class Solution {
//     public long subArrayRanges(int[] nums) {
//         int n = nums.length;
//         long ans = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 int min = Integer.MAX_VALUE;
//                 int max = Integer.MIN_VALUE;

//                 for (int k = i; k <= j; k++) {
//                     min = Math.min(min, nums[k]);
//                     max = Math.max(max, nums[k]);
//                 }

//                 ans += (max - min);
//             }
//         }
//         return ans;
//     }
// }

// class Solution {
//     public long subArrayRanges(int[] nums) {
//         int n = nums.length;
//         long ans = 0;

//         for (int i = 0; i < n; i++) {
//                 int min = Integer.MAX_VALUE;
//                 int max = Integer.MIN_VALUE;
//             for (int j = i; j < n; j++) {
//                     min = Math.min(min, nums[j]);
//                     max = Math.max(max, nums[j]);
//                     ans += (max - min);
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long sumMin = getSumSubarrayMins(nums);
        long sumMax = getSumSubarrayMax(nums);

        return sumMax - sumMin;
    }

    // 🔹 Sum of Subarray Minimums
    private long getSumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] ple = new int[n];
        int[] nle = new int[n];
        Stack<Integer> st = new Stack<>();

        // PLE
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // NLE
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            sum += (long) arr[i] * left * right;
        }
        return sum;
    }

    // 🔹 Sum of Subarray Maximums
    private long getSumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n]; // previous greater
        int[] nge = new int[n]; // next greater or equal
        Stack<Integer> st = new Stack<>();

        // PGE
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // NGE
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sum += (long) arr[i] * left * right;
        }
        return sum;
    }
}


