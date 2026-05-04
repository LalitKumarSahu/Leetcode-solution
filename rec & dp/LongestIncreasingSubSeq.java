import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubSeq {
  class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        int maxLen = 1;

        for(int i = 1; i<n; i++){

            for(int p = 0; p<i; p++){
                if(nums[p] < nums[i]){
                    lis[i] = Math.max(lis[i], 1 + lis[p]);
                }
            }

            if(lis[i] > maxLen){
                maxLen = lis[i];
            }
        }
        
        return maxLen;
    }
}
// printing longest increasing subsequence
// print lis
// jis idx ki vjha se lis update hota hai ush idx ko prev me store kar lenge
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        int prev[] = new int[n];
        for(int i = 0; i<n; i++){
            lis[i] = 1;
            prev[i] = i;
        }
        int maxLen = 1;
        int maxIdx = 0;
        for(int i = 1; i<n; i++){

            for(int p = 0; p<i; p++){
                if(nums[p] < nums[i]){
                    if(lis[i] < 1 + lis[p]){
                       lis[i] =  1 + lis[p];
                       prev[i] = p;
                    }
                    
                }
            }

            if(lis[i] > maxLen){
                maxLen = lis[i];
                maxIdx = i;
            }
        }
        ArrayList<Integer>res = new ArrayList<>();
        res.add(nums[maxIdx]);
        while(maxIdx != prev[maxIdx]){
            maxIdx = prev[maxIdx];
            res.add(0,nums[maxIdx]);
        }
        for(int i = 0; i<res.size(); i++){
            System.out.print(res.get(i));
        }
        return maxLen;

       
    }
}
}
