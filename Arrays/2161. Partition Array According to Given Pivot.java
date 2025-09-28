class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int lCount = 0, gCount = 0, pCount = 0;
        for(int num : nums){
            if(num < pivot){
                lCount++;
            }else if(num > pivot){
                gCount++;
            }else{
                pCount++;
            }
        }
        
        int res[] = new int[n];
        int i=0, j = lCount, k = lCount + pCount;
        for(int num : nums){
              if(num < pivot){
                res[i] = num;
                i++;
            }else if(num > pivot){
                res[k] = num;
                k++;
            }else{
                res[j] = num;
                j++;
            }
        }
        return res;
    }
}