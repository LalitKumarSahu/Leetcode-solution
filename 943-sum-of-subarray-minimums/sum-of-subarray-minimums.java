class Solution {
    // public int sumSubarrayMins(int[] arr) {
    //     int n = arr.length;
    //     int ans = 0;

    //     for (int i = 0; i < n; i++) {
    //         for (int j = i; j < n; j++) {
    //             int min = Integer.MAX_VALUE;

    //             for (int k = i; k <= j; k++) {
    //                 min = Math.min(min, arr[k]);
    //             }

    //             ans += min;
    //         }
    //     }
    //     return ans;
    // }

 // m-2 better soln
//  public int sumSubarrayMins(int[] arr) {
//     int n = arr.length;
//     long ans = 0;
//     int mod = (int)(1e9 + 7);

//     for (int i = 0; i < n; i++) {
//         int min = Integer.MAX_VALUE;
//         for (int j = i; j < n; j++) {
//             min = Math.min(min, arr[j]);
//             ans = (ans + min) % mod;
//         }
//     }
//     return (int) ans;
//  }

  // m-3 optimal soln
     public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] ple = new int[n]; // previous less element index
        int[] nle = new int[n]; // next less or equal element index

        Stack<Integer> st = new Stack<>();

        // 🔹 PLE
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // 🔹 NLE
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        // 🔹 Contribution calculation
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;

            ans = (ans + (arr[i] * left % MOD) * right % MOD) % MOD;
        }

        return (int) ans;

 }
}

