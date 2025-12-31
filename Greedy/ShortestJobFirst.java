package Greedy;

import java.util.Arrays;

public class ShortestJobFirst {
   static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int time = 0;
        int wt = 0;
        int n = bt.length;
        
        for(int i= 0; i<n; i++){
            wt += time;
            time += bt[i];
        }
        return wt/n;
    }
}
