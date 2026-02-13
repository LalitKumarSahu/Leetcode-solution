// m-1
import java.util.*;
public class Squares of a Sorted Array {
  class Solution1 {
    public int[] sortedSquares1(int[] nums) {

        int n = nums.length;

        for(int i = 0; i<n; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
   
// m-2
class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int left = 0;
        int right = n-1;
        int res[] = new int[n];
        int j = n-1;
        while(left <= right){
            int val1 = nums[left] * nums[left];
            int val2 = nums[right] * nums[right];

            if(val1 >= val2){
                res[j] = val1;
                left++;
                j--;
            }else{
                res[j] = val2;
                j--;
                right--;
            }
        }
        return res;
       
    }
}

}
