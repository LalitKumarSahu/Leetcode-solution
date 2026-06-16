// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         ArrayList<int[]>res = new ArrayList<>();
//         int i = 0;
//         int n = intervals.length;

//         //non-overlaping codn
//         while(i < n && intervals[i][1] < newInterval[0]){
//             res.add(intervals[i]);
//             i++;
//         }
//         // merging overlaping if any
//          while(i < n &&  newInterval[1] >= intervals[i][0]){
//            newInterval[0] =  Math.min(intervals[i][0],newInterval[0]);
//            newInterval[1] =  Math.max(intervals[i][1],newInterval[1]);
//             i++;
//         }
//         res.add(newInterval);
//         // append the remaing
//         while(i < n){
//             res.add(intervals[i]);
//             i++;
//         }
//         return res.toArray(new int[res.size()][]);
//     }
// }

// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         ArrayList<int[]>res = new ArrayList<>();
//         int i = 0;
//         int n = intervals.length;
        
//         //non-overlaping codn
//         while(i < n && intervals[i][1] < newInterval[0]){
//             res.add(intervals[i]);
//             i++;
//         }
//         // merging overlapping if any
//         while(i < n && newInterval[1] >= intervals[i][0]){
//             newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
//             newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
//             i++;

//         }
//         res.add(newInterval);

//          // remaning intervals
//         while(i < n){
//             res.add(intervals[i]);
//             i++;
//         }
//         return res.toArray(new int[res.size()][]);
        
//     }
// }
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      ArrayList<int[]>res = new ArrayList<>();
      int i = 0;
      int n = intervals.length;

      // non overlaping codn add direct into res
      while(i < n && intervals[i][1] < newInterval[0]){
        res.add(intervals[i]);
        i++;
      }


      // overlaping codn -> start ka min and and end ka max 
      while( i < n && newInterval[1] >= intervals[i][0]){
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;

      }
      res.add(newInterval);

      //append the remaining
      while(i < n){
        res.add(intervals[i]);
        i++;
      }
        
        return res.toArray(new int[res.size()][]);
    }
}