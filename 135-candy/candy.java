// class Solution {
//     public int candy(int[] ratings) {
//          int n = ratings.length;
//         int left[] = new int[n];
//         int right[] = new int[n];
        
//         left[0] = 1;
//         right[n-1] = 1;
        
//         // Left to Right
//         for (int i = 1; i < n; i++) {
//             if (ratings[i] > ratings[i - 1]) {
//                 left[i] = left[i - 1] + 1;
//             } else {
//                 left[i] = 1;
//             }
//         }
        
//         // Right to Left  ✅ FIXED
//         for (int i = n - 2; i >= 0; i--) {
//             if (ratings[i] > ratings[i + 1]) {   // ✅ correct
//                 right[i] = right[i + 1] + 1;
//             } else {
//                 right[i] = 1;
//             }
//         }
        
//         int sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += Math.max(left[i], right[i]);
//         }
        
//         return sum;
//     }
// }

  // optimal soln by using slope method
    // m-3 optimal soln
    class Solution {
    public int candy(int[] ratings) {
         int n = ratings.length;
         int i = 1;
         int sum = 1;

         while( i < n){
            // flat slope
            if(ratings[i] == ratings[i-1]){
                sum = sum + 1;
                i++;
                continue;
            }
            // inc slope
            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                peak += 1;
                sum += peak;
                i++;
            }
            // dec slope
            int down = 1;
             while(i < n && ratings[i] < ratings[i-1]){
                sum += down;
                i++;
                down += 1;
            }
            // peak adjustment
            if(down > peak){
                sum += down - peak;
            }
         }
        return sum;
    }
}