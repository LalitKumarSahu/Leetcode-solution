import java.util.ArrayList;

public class InsertInterval {
  public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
         ArrayList<int[]>res = new ArrayList<>();
       int i = 0;
       int n = intervals.length;

       // nonOverlapping hai newInterval to add into the res
       while(i < n  && intervals[i][1] < newInterval[0]){
             res.add(intervals[i]);
             i++;
       }

       // if overlaping any
       while(i < n &&  newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;

       }
       res.add(newInterval);

       // insert overlaping and merge them after that interval is persent

       while(i < n){
        res.add(intervals[i]);
        i++;
       }
       
       return res;
    }
}


// m-2 brute force by findnmaxOverlap
class Solution {
    static int findPlatform(int arr[], int dep[], int n) {

        int maxOverlap = 0;

        for (int i = 0; i < n; i++) {
            int overlap = 1; // current train itself

            for (int j = 0; j < n; j++) {
                if (i != j &&
                    arr[i] < dep[j] &&
                    arr[j] < dep[i]) {
                    overlap++;
                }
            }
            maxOverlap = Math.max(maxOverlap, overlap);
        }
        return maxOverlap;
    }
}
