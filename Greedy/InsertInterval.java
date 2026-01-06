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
