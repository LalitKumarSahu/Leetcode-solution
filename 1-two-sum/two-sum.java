// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // Brute Force 
//         for(int i= 0; i<nums.length; i++){
//             for(int j = i+1; j<nums.length; j++){
//                 if(nums[i] + nums[j] == target){
//                     return new int[] {i,j};
//                 }
//             }
//         }
//       return null;
        
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int res[] = new int[2];
        for(int i= 0; i<nums.length; i++){
            int partner = target - nums[i];
            if(map.containsKey(partner)){
                res[0] = i;
                res[1] = map.get(partner);
                return res;
             }
             map.put(nums[i], i);
            }
        
      return null;
        
    }
}