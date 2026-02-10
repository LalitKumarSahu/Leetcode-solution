// class Solution {
//     public int maximumSum(int[] nums) {
//         HashMap<Integer, Integer>map = new HashMap<>();
//         int ans = -1;
//         for(int num : nums){
//             int digitSum = getDigitSum(num);
//             if(map.containsKey(digitSum)){
//                 int prev = map.get(digitSum);
//                 ans = Math.max(ans, prev + num);
//                 map.put(digitSum, Math.max(prev, num));
//             }else{
//                 map.put(digitSum, num);
//             }
//         }
//         return ans;
       
//     }
//     public int getDigitSum(int num){
//        int sum = 0;
//            while(num > 0){
//             sum += (num%10); // last digit
//             num /= 10; // last digit remove
//            } 
//            return sum;    
//     }
// }

class Solution {
    // 10^9 - 1 = 999999999 = 81 is the digit sum
    public int maximumSum(int[] nums) {
        // HashMap<Integer, Integer>map = new HashMap<>();
        int map[] = new int[82];
        int ans = -1;
        for(int num : nums){
            int digitSum = getDigitSum(num);
            if(map[digitSum] > 0){
                // int prev = map.get(digitSum);
                int prev = map[digitSum];
                ans = Math.max(ans, prev + num);
                map[digitSum] =  Math.max(prev, num);
                // map.put(digitSum, Math.max(prev, num));
            }else{
                // map.put(digitSum, num);
                map[digitSum] = num;
            }
        }
        return ans;
       
    }
    public int getDigitSum(int num){
       int sum = 0;
           while(num > 0){
            sum += (num%10); // last digit
            num /= 10; // last digit remove
           } 
           return sum;    
    }
}