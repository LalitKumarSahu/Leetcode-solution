import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubseq {
  //------------next method without dp-------->
/*Start:
temp = []

10  → temp empty → ADD
temp = [10]

9   → 9 < 10 → REPLACE
temp = [9]

2   → 2 < 9 → REPLACE
temp = [2]

5   → 5 > 2 → ADD
temp = [2, 5]

3   → 3 < 5 → REPLACE
temp = [2, 3]

7   → 7 > 3 → ADD
temp = [2, 3, 7]

101 → 101 > 7 → ADD
temp = [2, 3, 7, 101]

18  → 18 < 101 → REPLACE
temp = [2, 3, 7, 18]

*/

class Solution {
    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
      ArrayList<Integer>temp = new ArrayList<>();

      for(int x : nums){
        if(temp.size() == 0 || x > temp.get(temp.size() -1)){
            temp.add(x);
        }else{
            int idx = Collections.binarySearch(temp, x);
            if(idx < 0){
                idx = -(idx + 1);
            }
            temp.set(idx, x);
        }
      }
      return temp.size();
    }
}
}
