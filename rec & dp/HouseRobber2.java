public class HouseRobber2 {
  class Solution {
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int prev2 = 0;
        int prev1 = nums[0];
        int ans = 0;
         
         for(int i = 2; i < n+1; i++ ){
            int pick = nums[i - 1] + prev2;
            int noPick = 0 + prev1;
            ans = Math.max(pick, noPick);
            prev2 = prev1;
            prev1 = ans;
         }
         return ans;
    }
    // pehla elm gayab kar do fir answer nikal lo
    // last elm gayab kar do fir answer nikal lo
    // dono ka max hoga ans

    public int rob(int nums[]){
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int num1[] = new int[n-1]; // nums1 me pehla elm nhi hai
        int num2[] = new int[n-1]; // nums2 me last elm nhi hai

        int j = 0;
        int k  = 0;
        for(int i=0; i<n; i++){
            if( i != 0){
                num1[j] = nums[i];
                j++;
            }
            if( i != n-1){
                num2[k] = nums[i];
                k++;
            }
        }
        return Math.max(rob1(num1), rob1(num2));
    }

}
}
