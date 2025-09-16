import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    int count = 0;

    public int countStableSubsequences(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        generate(0, nums, curr);
        return count;
    }

    // Generate all subsequences (pick / no pick)
    private void generate(int index, int[] nums, List<Integer> curr) {
        if (index == nums.length) {
            if (!curr.isEmpty()) {
                if (isStable(curr)) { // yahi condition check
                    count++;
                    count %= MOD;
                }
            }
            return;
        }

        // 1️⃣ Not pick
        generate(index + 1, nums, curr);

        // 2️⃣ Pick
        curr.add(nums[index]);
        generate(index + 1, nums, curr);
        curr.remove(curr.size() - 1); // backtrack
    }

    // Stable check: no 3 consecutive same parity
    private boolean isStable(List<Integer> subseq) {
        for (int i = 2; i < subseq.size(); i++) {
            int a = subseq.get(i), b = subseq.get(i - 1), c = subseq.get(i - 2);
            if ((a % 2 == b % 2) && (b % 2 == c % 2)) {
                return false;
            }
        }
        return true;
    }
}

// class Solution {
//     static final int MOD = 1_000_000_007;
//     int[] nums;
//     Integer[][][] dp; 

//     public int countStableSubsequences(int[] nums) {
//         this.nums = nums;
//         // dimensions: index, lastParity+1 (to handle -1), count
//         dp = new Integer[nums.length][3][3]; 
//         return dfs(0, -1, 0);
//     }

//     private int dfs(int i, int lastParity, int count) {
//         if (i == nums.length) {
//             return 0;
//         }

//         int lp = lastParity + 1; // shift -1 → 0, 0 → 1, 1 → 2
//         if (dp[i][lp][count] != null) return dp[i][lp][count];

//         long ans = 0;

//         // 1️⃣ Skip current element
//         ans += dfs(i + 1, lastParity, count);

//         // 2️⃣ Pick current element
//         int p = nums[i] % 2;
//         if (lastParity == -1) {
//             // subsequence start
//             ans += 1; // subsequence [nums[i]]
//             ans += dfs(i + 1, p, 1);
//         } else if (p == lastParity) {
//             if (count < 2) {
//                 ans += 1;
//                 ans += dfs(i + 1, p, count + 1);
//             }
//         } else {
//             ans += 1;
//             ans += dfs(i + 1, p, 1);
//         }

//         ans %= MOD;
//         return dp[i][lp][count] = (int) ans;
//     }
// }
