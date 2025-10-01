// brute force
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int sum = 0;
                for(int k = j+1; k<n; k++ ){
                    sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0){
                      List<Integer>ans = Arrays.asList(nums[i], nums[j], nums[k]);
                      Collections.sort(ans); // avoid duplicate order
                      if(!res.contains(ans)){
                      res.add(ans);
                    }
                    }
                }
            }
        }
        return res;
        
    }
}

// using 2 sum tecnique
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
        HashSet<List<Integer>>res = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
         int j = i+1;
         int k = nums.length-1;

         while(j<k){
            int sum = nums[j] + nums[k];
            if(sum == -nums[i]){
                 res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
            
              
            }else if(sum < -nums[i]){ // bada vala leke dekenge
            j++;
         }else if(sum > -nums[i]){ // chota vala leke dekenge
            k--;
         }

     }
 }
    
   
     return new ArrayList<>(res);
    }
}