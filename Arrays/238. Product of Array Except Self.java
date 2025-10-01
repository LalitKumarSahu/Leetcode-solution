class Solution {
    // m-1 brute force tc:O(N2), scc:O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        for(int i = 0; i<n; i++){
            int mul = 1;

            for(int j = 0; j<n; j++){

                if(i==j) continue;

                mul = mul * nums[j];
            }
            res[i] = mul;
        }
        
        return res;
    }
}

//m-2 by using perfix and suffix
class Solution {
    // m-1 brute force tc:O(N2), scc:O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = 1;
        // calc perfix
        for(int i = 1; i<n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int suffix = 1;
        for(int j = n-1; j>=0; j--){
            ans[j] = ans[j] * suffix;
            suffix = suffix * nums[j];
        }

        
        return ans;
    }
}