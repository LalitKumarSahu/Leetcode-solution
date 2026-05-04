import java.util.Arrays;

public class MaximumLengthOfPairChain {
  class Solution {
  
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);  // NlogN
        int n = pairs.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        int maxLen = 1;
        for(int i=1; i<n; i++){ //N^2
            for(int p=0; p<i; p++){
                if(pairs[p][1] < pairs[i][0]){  // [a,b]& [c,d] -> b < c
                    lis[i] = Math.max(lis[i], 1 + lis[p]);
                }
            }
            if(maxLen < lis[i]){
                maxLen = lis[i];
            }
        }
        return maxLen;  

    }
 }
}
