// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         ArrayList<Integer>res = new ArrayList<>();

//         HashSet<Integer>set = new HashSet<>();

//         for(int num : nums){
//             if(set.contains(num)){
//                 res.add(num);
//             }
//             set.add(num);
//         }
//         return res;
        
//     }
// }

// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         ArrayList<Integer>res = new ArrayList<>();

//         HashMap<Integer,Integer>map = new HashMap<>();
//         for(int num : nums){
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         for(int key : map.keySet()){
//             if(map.get(key) == 2){
//                 res.add(key);
//             }
//         }
//         return res;
//     }
// }

// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         ArrayList<Integer>res = new ArrayList<>();
//         int n = nums.length;
//         for(int i = 0; i<n; i++){
//            int elm = Math.abs(nums[i]);
//            int seat = elm - 1;

//            if(nums[seat] < 0){
//             res.add(elm);
//            }else{
//             nums[seat] = -nums[seat];
//            }
//         }
//         return res;
//     }
// }

// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         ArrayList<Integer>res = new ArrayList<>();

//         HashMap<Integer, Integer>map = new HashMap<>();
//         for(int num : nums){
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         for(int key : map.keySet()){
//             if(map.get(key) == 2){
//                 res.add(key);
//             }
//         }
//         return res;
//     }
// }

// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         ArrayList<Integer>res = new ArrayList<>();

//         HashSet<Integer>set = new HashSet<>();
//         for(int num : nums){
//             if(set.contains(num)){
//                 res.add(num);
//             }
//             set.add(num);
//         }

//         return res;
//     }
// }

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer>res = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            int elm = Math.abs(nums[i]);
            int seat = elm - 1;

            if(nums[seat] < 0){
                res.add(elm);
            } 
            else{
            nums[seat] = -nums[seat];
            }
        }
        return res;
    }
}