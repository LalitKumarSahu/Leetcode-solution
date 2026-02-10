class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int ans = -1;
        for(int num : nums){
            int digitSum = getDigitSum(num);
            if(map.containsKey(digitSum)){
                int prev = map.get(digitSum);
                ans = Math.max(ans, prev + num);
                map.put(digitSum, Math.max(prev, num));
            }else{
                map.put(digitSum, num);
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