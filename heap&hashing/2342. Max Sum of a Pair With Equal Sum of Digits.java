// brute force
// digit sum ko map me store kar lenge her digit sum ke liye maximum 2 value ka sum find karenge


// m-2 optimize instead of storing all value in array store only 2 value 
class Solution {
    public int maximumSum(int[] nums) {
       HashMap<Integer,Integer>map = new HashMap<>();
        int ans = -1;
        for(int num : nums){
            int digitSum = getDigitSum(num);
            if(map.containsKey(digitSum)){
                int prevNum = map.get(digitSum);
                ans = Math.max(ans, prevNum + num);
                map.put(digitSum, Math.max(prevNum, num));
            }else{
                map.put(digitSum, num);
            }
        }
        return ans;
    }
    public int getDigitSum(int num){
        int sum = 0;
        while(num >0){
            sum += (num % 10); // extract last digit
            num /= 10; // remove last digit
        }
        return sum;
    }
}