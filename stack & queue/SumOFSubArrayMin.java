public class SumOFSubArrayMin {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    min = Math.min(min, arr[k]);
                }

                ans += min;
            }
        }
        return ans;
    }

 // m-2 better soln
 public int sumSubarrayMins2(int[] arr) {
    int n = arr.length;
    long ans = 0;
    int mod = (int)(1e9 + 7);

    for (int i = 0; i < n; i++) {
        int min = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            min = Math.min(min, arr[j]);
            ans = (ans + min) % mod;
        }
    }
    return (int) ans;
 }

}

 // m-3 optimal soln
