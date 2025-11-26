public class CountInversion {
   // Brute force
    public long numberOfInversions1(int[] nums) {
           int n = nums.length;
            int count = 0;
           for(int i = 0; i<n; i++){
             for(int j = i+1; j<n; j++){
                if( nums[i] > nums[j])count++;
             }
           }
           return count;
    }

    // optimal soln
   }
}
