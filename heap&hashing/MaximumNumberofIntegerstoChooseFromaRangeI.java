import java.util.HashSet;

public class MaximumNumberofIntegerstoChooseFromaRangeI {
  // jo number choose karna hai vo 1 to n ke beech ka hona chaiyhe
// unka sum maxsum se jyda na ho
//jo number choose kiye ho vo banned arr me na ho

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

      
        HashSet<Integer>set = new HashSet<>();

        for(int elm : banned){
            set.add(elm);
        }
        int sum = 0;
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(set.contains(i)) continue;
            
              sum += i;
            if(sum > maxSum)
              break;
             count++;
        }
        return count;
    }
}
}
