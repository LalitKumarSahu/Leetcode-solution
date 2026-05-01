import java.util.HashMap;
public class 350. Intersection of Two Arrays II {
  class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer>hm =  new HashMap<>();
         for(int num : nums1){
          hm.put(num, hm.getOrDefault(num , 0) + 1);
         }

         ArrayList<Integer>list = new ArrayList<>();
         for(int num : nums2){
            if(hm.containsKey(num)){
               list.add(num);
               if(hm.get(num) == 1){
                hm.remove(num);
               }else{
                hm.put(num, hm.get(num) - 1);
               }
            }
         }
         // convert ArrayList into int []
         int res[] = new int[list.size()];
         for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
         }
         return res;
    }
}
}
