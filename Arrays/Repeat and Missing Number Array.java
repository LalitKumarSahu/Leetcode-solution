import java.util.*;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int n = A.length;
        int duplicate = -1, missing = -1;

        // Step 1: Find duplicate
        for (int i = 0; i < n; i++) {
            int elm = Math.abs(A[i]);
            int seat = elm - 1;

            if (A[seat] < 0) {
                // Already visited -> duplicate found
                duplicate = elm;
            } else {
                A[seat] = -A[seat];
            }
        }

        // Step 2: Find missing (index with positive value)
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}
