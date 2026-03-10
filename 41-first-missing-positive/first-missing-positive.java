// m1- brute force loop and lenear search
// m2 - set and loop space for stroing elm into set
//m3 - sorting cand < nums[i] => missing hai

//tc:O(N) + O(N) + O(N), sc:O(1)
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int n = nums.length;
//         // filtering array
//         for(int i = 0; i<n; i++){
//             if(nums[i] <= 0 || nums[i] > n){
//                 nums[i] = n+1;
//             }
//         }
//         // mark visited
//         for(int i = 0; i<n; i++){
//             int element = Math.abs(nums[i]);

//             if(element == n+1){
//                 continue;
//             }
//             int seat = element - 1;
//             if(nums[seat] > 0){
//                 nums[seat] = -nums[seat];
//             }
//         }

//         //find 1st +ve number
//         for(int i = 0; i<n; i++){
//             if(nums[i] > 0){
//                 return i+1;
//             }
//         }
//         return n+1;
//     }
//  }


class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // filtering the array
        for(int i = 0; i<n; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n + 1;
            }
        }

        for(int i = 0; i<n; i++){
            int elm = Math.abs(nums[i]);
            int seat = elm - 1;

            if(elm == n + 1){
             continue;
            } 
            if(nums[seat] > 0){
                nums[seat] = -nums[seat];
            }

        }
        // find 1st postive
        for(int i = 0; i<n; i++){
            if(nums[i] >  0){
                return i+1;
            }
        }
        
        return n+1;
    }
 }





