class Solution {
    public int earliestTime(int[][] tasks) {

        int minTime = Integer.MAX_VALUE;

        for(int t[] : tasks){
            int t1 = t[0];
            int t2 =  t[1];

            minTime = Math.min(minTime, t1+t2);
        }
        return minTime;
        
    }
}