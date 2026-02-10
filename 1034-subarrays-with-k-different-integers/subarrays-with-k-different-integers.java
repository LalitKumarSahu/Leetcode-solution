class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
         return countSubarraysWithKDistinct(nums,  k) - countSubarraysWithKDistinct(nums,  k -1);
    }

    public int countSubarraysWithKDistinct(int nums[],  int k){
      HashMap<Integer,Integer>map = new HashMap<>(); 
        int n = nums.length;
        int start = 0;
        int end = 0;
        int count = 0;
     
        while(end < n){
            // exp
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            //shrink
            while(map.size() > k){
                 map.put(nums[start], map.getOrDefault(nums[start], 0) - 1);
                 if(map.get(nums[start]) == 0){
                    map.remove(nums[start]);
                 }
                 start++;
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }
}