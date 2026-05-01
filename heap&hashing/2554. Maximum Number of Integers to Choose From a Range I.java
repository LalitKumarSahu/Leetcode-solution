import java.util.HashSet;
public class 2554. Maximum Number of Integers to Choose From a Range I {
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
