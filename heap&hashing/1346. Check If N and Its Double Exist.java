public class 1346. Check If N and Its Double Exist {
  class Solution {
    // elm * 2 or elm/2 -> 10 = 20 or 10/2 = 5 ho
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer>set = new HashSet<>();

        for(int element : arr){

            if(set.contains(element * 2) || (element % 2 == 0) && (set.contains(element/2))){
                return true;
            }
            set.add(element);
        }
        return false;
        
    }
}
}
