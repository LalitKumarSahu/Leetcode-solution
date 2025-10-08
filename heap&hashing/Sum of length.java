import java.util.*;

// class Solution {
//     // tc: O(n) additions + O(n) removals.
//     //sc : O(N) using hashset
//     public int sumoflength(int arr[]) {
//         int n = arr.length;
//         int ans = 0; // Final sum of lengths of all distinct subarrays
        
//         HashSet<Integer> set = new HashSet<>();
//         int j = 0; // Right pointer for sliding window

//         // i = left pointer of window
//         for (int i = 0; i < n; i++) {

//             // Expand window to include distinct elements
//             while (j < n && !set.contains(arr[j])) {
//                 set.add(arr[j]);
//                 j++;
//             }

//             // For current i, number of distinct subarrays = (j - i)
//             // Sum of lengths of all those subarrays = (j - i) * (j - i + 1) / 2
//             ans += ((j - i) * (j - i + 1)) / 2;

//             // Move window ahead — remove arr[i] from set
//             set.remove(arr[i]);
//         }
//         return ans;
//     }
// }

// by return into modulo 1000000007
import java.util.*;

class Solution {
    // tc: O(n) additions + O(n) removals.
    //sc : O(N) using hashset
    public int sumoflength(int arr[]) {
        int n = arr.length;
        int mod = 1000000007;
        long ans = 0; // Final sum of lengths of all distinct subarrays
        
        HashSet<Integer> set = new HashSet<>();
        int j = 0; // Right pointer for sliding window

        // i = left pointer of window
        for (int i = 0; i < n; i++) {

            // Expand window to include distinct elements
            while (j < n && !set.contains(arr[j])) {
                set.add(arr[j]);
                j++;
            }

            // For current i, number of distinct subarrays = (j - i)
            // Sum of lengths of all those subarrays = (j - i) * (j - i + 1) / 2
            long len = j-i;
            long subArray = (len * (len + 1)/2)%mod;
            ans = (ans + subArray) % mod;

            // Move window ahead — remove arr[i] from set
            set.remove(arr[i]);
        }
        return (int)ans;
    }
}
