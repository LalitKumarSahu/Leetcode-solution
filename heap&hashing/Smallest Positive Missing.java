import java.util.*;

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        if (n == 0) return 1; // agar array empty ho to 1 return kar dete hain (case-dependent)

        int maxVal = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int v : arr) {
            set.add(v);
            maxVal = Math.max(maxVal, v);
        }

        // check numbers from 1 to maxVal
        for (int i = 1; i <= maxVal; i++) {
            if (!set.contains(i)) {
                return i; // pehla missing
            }
        }

        // agar 1..maxVal me koi missing nahi tha, to maxVal+1 missing maan lo (depends on problem)
        return maxVal + 1;
    }
}

import java.util.*;

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Replace negatives and zeros with n+1
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                arr[i] = n + 1;
            }
        }

        // Step 2: Mark numbers as negative if their value is within range
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num >= 1 && num <= n) {
                int seat = num - 1;
                if (arr[seat] > 0) {
                    arr[seat] = -arr[seat];
                }
            }
        }

        // Step 3: First positive index = missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        // Step 4: If all are marked, then answer = n + 1
        return n + 1;
    }
}


