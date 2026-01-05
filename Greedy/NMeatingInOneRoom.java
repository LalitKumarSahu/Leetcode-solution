import java.util.Arrays;

public class NMeatingInOneRoom {

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
       
       int n = start.length;
       int meet[][] = new int[n][2];
       for(int i = 0; i<n; i++){
           meet[i][0] = start[i];
           meet[i][1] = end[i];
       }
       Arrays.sort(meet, (a, b) -> a[1] - b[1]);
       
       int count = 1;
       int lastEnd = meet[0][1];
       
       for(int i = 1; i<n; i++){
           if(meet[i][0] > lastEnd){
               count++;
               lastEnd = meet[i][1];
           }
       }
       return count;
       
    }
}


