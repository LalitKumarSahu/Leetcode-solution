import java.util.HashSet;

public class CheckIfNandItsDoubleExist {
  class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer>set = new HashSet<>();

        for(int element : arr){
            // devide ke case me elm should be even 
            if(set.contains(element * 2) || (element % 2 == 0) && (set.contains(element/2))){
                return true;
            }
            set.add(element);
        }
        return false;
        
    }
}
}
