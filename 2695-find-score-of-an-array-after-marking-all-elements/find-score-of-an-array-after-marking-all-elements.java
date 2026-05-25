class Solution {
    //---tc-O(N) + O(NlogN) + O(N)--->
    //----sc-O(N) + O(N)------>
    public long findScore(int[] nums) {
        int n = nums.length;

        // make copy array[elem, idx]
        int copy[][] = new int[n][2];
        for(int i=0; i < n; i++){
            copy[i][0] = nums[i];
            copy[i][1] = i;
        }
        // sort
        Arrays.sort(copy, (a,b) -> a[0] - b[0]);

        long res = 0;
        for(int i=0; i < n; i++){ 
          int elm = copy[i][0];
          int idx = copy[i][1];
          if(nums[idx] < 0) continue; // it's means elm is already marked
           res += nums[idx];
           nums[idx] = -nums[idx]; // mark

           if(idx-1 >= 0 && nums[idx-1] > 0){ // if it is not mark and btw arr
           nums[idx-1] = -nums[idx-1];   
           }

           if(idx+1 < n && nums[idx+1] > 0){  // if it is not mark and btw arr
           nums[idx+1] = -nums[idx+1]; 
           }
        }
        return res;   
    }
}
