class Solution {
    // kon shi window me minimum zero hai utne hi swap honge
    // window ka size no of 1 jitne honge
    public int minSwaps(int[] nums) {
        // window size = count of 1
        int windowSize = 0;
        for(int num : nums){
            if(num == 1){
                windowSize++;
            }
        }

        // find zero in first window
        int currZero = 0;
        for(int i = 0; i<windowSize; i++){
            if(nums[i] == 0){
                currZero++;
            }
        }
         
        //solve for remaning window
        int start = 0;
        int end = windowSize - 1;
        int n = nums.length;
        int minZero = currZero;
        while(start < n){
            //if remove elm is 0, decrement 0 counter
            if(nums[start] == 0){
                currZero--;
            }
            start++;

            // if include elm is 0, increment 0 counter
            end++;
            if(nums[end%n] == 0){ // for circular arr
                currZero++;
            }

            minZero = Math.min(minZero, currZero);
        }
        return minZero;
        
    }
}