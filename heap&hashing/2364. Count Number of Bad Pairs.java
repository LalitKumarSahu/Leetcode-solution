public class 2364. Count Number of Bad Pairs {
  class Solution {
    public long countBadPairs(int[] nums) {

        int n = nums.length;
        int count = 0;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(i < j && j-i != nums[j] - nums[i]){
                    count++;
                }
            }
        }
        return count; 
        
    }
}
// m-2 by using hashMap

    public long countBadPairs2(int[] nums) {
      
        long n = nums.length;
        long goodPair = 0;
        long totalPair = n * (n-1)/2;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int val = i - nums[i];
            int valCount = map.getOrDefault(val, 0);
            goodPair += valCount;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        return totalPair - goodPair;
    }



}
