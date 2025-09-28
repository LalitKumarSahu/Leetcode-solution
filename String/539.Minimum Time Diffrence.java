class Solution {
    public int findMinDifference(List<String> timePoints) {
        // convert input to minutes
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
            minutes[i] = h * 60 + m;
        }

        // sort times in ascending order
        Arrays.sort(minutes);

        // find minimum difference across adjacent elements
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        // consider difference between last and first element
        return Math.min(
            ans,
            24 * 60 - minutes[minutes.length - 1] + minutes[0]
        );
    }
}

// m-2 optimize tc by using bucket sort
class Solution {
    public int findMinDifference(List<String> timePoints) {
        // convert input to minutes
        boolean[] mins = new boolean[1440];
        for (String time : timePoints){
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));
             int minutes = h * 60 + m;
            if(mins[minutes] == true) return 0;
            mins[minutes] = true;
        }

        // find minimum difference across adjacent elements
        int prev = -1;
        int firstVal = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int curr = 0; curr < 1440; curr++) {
            if(mins[curr]){
                if(prev == -1){
                    firstVal = curr;
                    prev = curr;
                }else{

                    minDiff = Math.min(minDiff, curr - prev);
                    prev = curr;
                }
            }
        }
         // consider difference between last and first element
        if(prev != -1){
            minDiff = Math.min(minDiff, 1440 + firstVal - prev);
        }

       
       return minDiff;
    }
}