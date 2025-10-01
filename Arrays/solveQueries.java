class Solution {
    public int[] solveQueries(int[] nums, int[][] Queries, int k) {
        // Code here
       int n = Queries.length;
       int res[] = new int[n];
       
       for(int i = 0; i<n; i++){
           int left = Queries[i][0]-1;
           int right =  Queries[i][1]-1;
           
           HashMap<Integer, Integer>map = new HashMap<>();
           for(int j = left; j<=right; j++){
               map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
           }
           
           int count= 0;
           for(int key : map.keySet()){
               if(map.get(key) >= k){
                   count++;
               }
              
           }
            res[i] = count;
       }
       return res;
        
    }
}