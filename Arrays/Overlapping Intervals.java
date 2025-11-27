import java.util.*;

class Solution {
       // brute foce
    // public int[][] mergeOverlap(int[][] arr) {
    //       for i = 0 → n-1
    //        for j = i+1 → n-1
    //        if arr[i][0] <= arr[j][1]  AND arr[j][0] <= arr[i][1]
    //         newStart = min(arr[i][0], arr[j][0])
    //         newEnd   = max(arr[i][1], arr[j][1])

    //         arr[i] = [newStart, newEnd]


// }
    
// optimal soln
    public int[][] mergeOverlap(int[][] arr) {
        // Step 1: Sort by starting time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        
        // Step 2: Start with first interval
        int[] curr = arr[0];
        res.add(curr);

        // Step 3: Traverse all intervals
        for (int i = 1; i < arr.length; i++) {
            int start = arr[i][0];
            int end   = arr[i][1];

            if (curr[1] >= start) {
                // Overlap → merge
                curr[1] = Math.max(curr[1], end);
            } else {
                // No overlap → add new interval
                curr = arr[i];
                res.add(curr);
            }
        }

        // Step 4: Convert list → array
        return res.toArray(new int[res.size()][]);
    }
}