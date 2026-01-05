import java.util.Arrays;

public class NonOverLapingIntervals {
      public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 1;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            // Non-overlapping condition for LC 435
            if (intervals[i][0] >= lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }

        // Minimum intervals to remove
        return n - count;
    }
}
