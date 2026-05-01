import java.util.HashMap;
public class 1726. Tuple with Same Product {
  class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int n = nums.length;
     
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int num = nums[i] * nums[j];
                map.put(num, map.getOrDefault(num , 0) + 1);
            }
        }
        int ans = 0;
        for(int num : map.keySet()){
            int count = map.get(num);

            if(count >= 2){
                int comb = (count * (count -1))/2;
                ans = ans + comb * 8;

            }
        }
        return ans;
        
    }
}
}
