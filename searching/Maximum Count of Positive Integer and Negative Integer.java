public class Maximum Count of Positive Integer and Negative Integer {
  class Solution {
    public int maximumCount(int[] nums) {
        int pcount = 0;
        int ncount = 0;

        for(int num : nums){
            if(num > 0){
                pcount++;
            } else if(num < 0){
                ncount++;
            }
        }

        return Math.max(pcount, ncount);
    }
}


// m-2
class Solution {
    public int maximumCount(int[] nums) {
       //negpos >-1 --> first zero ka idx
       //pospos >0 --->first postive ka idx
       int  n = nums.length;
       int negPos = binarySearch(nums, 0, n-1, -1);
       int posPos = binarySearch(nums, negPos, n-1, 0);
       int posPosCount = (n - posPos);

       return Math.max(negPos, posPosCount); 

    }

    public int binarySearch(int nums[], int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return start;
    }
}
}
