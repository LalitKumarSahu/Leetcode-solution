public class sort012 {
  class Solution {
   //brute force using soritng, tc : O(NLogN), sc :O(N)
    public void sort012(int[] arr) {
        Arrays.sort(arr);
    }
    
     // better by counting 0,1,2 tc : O(), sc :O(N)
    public void sort012(int[] arr) {
         int count0 = 0, count1 = 0, count2 = 0;
         // Count 0s, 1s, 2s
        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int i = 0;

        // Fill all 0's
        while (count0-- > 0) {
            arr[i++] = 0;
        }

        // Fill all 1's
        while (count1-- > 0) {
            arr[i++] = 1;
        }

        // Fill all 2's
        while (count2-- > 0) {
            arr[i++] = 2;
        }
        
    }
}
}
