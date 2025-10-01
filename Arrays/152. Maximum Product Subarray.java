// brute force Approach O(N^3)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= nums[k];
                }
                maxProd = Math.max(maxProd, prod);
            }
        }
        return maxProd;

    }
}

// brute force Approach-O(N^2)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                 prod *= nums[j];
                
                maxProd = Math.max(maxProd, prod);
            }
        }
        return maxProd;

    }
}

// optimization
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxProd = Integer.MIN_VALUE;
        int perfix = 1, suffix = 1;
        for (int i = 0; i < n; i++) {

            if(perfix == 0) perfix = 1;
            if(suffix == 0) suffix = 1;

            perfix = perfix * nums[i];
            suffix = suffix * nums[n-i-1];
            maxProd = Math.max(maxProd, Math.max(perfix, suffix));
        }  
        return maxProd;

    }
}
