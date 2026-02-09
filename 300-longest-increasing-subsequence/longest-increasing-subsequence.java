// class Solution {
//     public int lengthOfLIS(int[] nums) {
//       int n = nums.length;
//       int lis[] = new int[n];
//       Arrays.fill(lis, 1);
    
//     int maxLen = 1;
//       for(int i=1; i<n; i++){
//         for(int p = 0; p < i; p++){
//             if(nums[p] < nums[i]){
//                 lis[i] = Math.max(lis[i] , 1 + lis[p]);
//             }
//         }
//         if(lis[i] > maxLen){
//             maxLen = lis[i];
//         }
//       } 
//       return maxLen;
//     }
// }

// m-2 piche to deko 


// class Solution {
//     public int lengthOfLIS(int[] nums) {
//       int n = nums.length;
//       int lis[] = new int[n];
//       int prev[] = new int[n];

//      for(int i=0; i<n; i++){
//         lis[i] = 1;
//         prev[i] = i;
//      }
    
//     int maxLen = 1;
//     int maxIdx = 0;
//       for(int i=1; i<n; i++){
//         for(int p = 0; p < i; p++){
//             if(nums[p] < nums[i]){
//                 if(lis[i] < 1 + lis[p]){
//                    lis[i] =  1 + lis[p];
//                    prev[i] = p;// prev idx jiske vjha she change hua ans
//                 }
            
//             }
//         }
//         if(lis[i] > maxLen){
//             maxLen = lis[i];
//             maxIdx = i;
//         }
//       } 

//       ArrayList<Integer>list = new ArrayList<>();
//       list.add(nums[maxIdx]);
//       while( maxIdx != prev[maxIdx]){
//         maxIdx = prev[maxIdx];
//         list.add(0,nums[maxIdx]);
//       }
//       for(int i=0; i<list.size(); i++){
//         System.out.print(list.get(i) + ", ");
//       }
//       return maxLen;
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
      ArrayList<Integer>temp = new ArrayList<>();

      for(int x : nums){
        if(temp.size() == 0 || x > temp.get(temp.size() -1)){
            temp.add(x);
        }else{
            int idx = Collections.binarySearch(temp, x);
            if(idx < 0){
                idx = -(idx + 1);
            }
            temp.set(idx, x);
        }
      }
      return temp.size();
    }
}


