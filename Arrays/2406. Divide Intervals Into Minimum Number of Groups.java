class Solution {
    public int minGroups(int[][] intervals) {
        int max = Integer.MIN_VALUE; // for array
        int min = Integer.MAX_VALUE; // it is the starting point
        int n = intervals.length;

        for(int i = 0; i < n; i++){ // O(N)
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]); // 10
           

        }

        int eventCount[] = new int[max+2]; // 0 to 11

        for(int i = 0; i < n; i++){   // O(N)
            eventCount[intervals[i][0]]++;
            eventCount[intervals[i][1] + 1]--;

        }

        int maxOverlap = 0 ;
        int sum = 0;
        for(int i = min; i<max+2; i++){ // O(K)
            sum += eventCount[i];
             maxOverlap = Math.max(maxOverlap, sum);
        }
        return maxOverlap;
        
    }
}