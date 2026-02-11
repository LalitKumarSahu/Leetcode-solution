// class Solution {
//     public int numberOfAlternatingGroups(int[] colors, int k) {
//         int left = 0;
//         int n = colors.length;
//         int res = 0;

//         for(int right = 1; right < (n+k-1); right++){
            
//             if(colors[right % n] == colors[(right-1) % n]){ // skip entire subArray
//                 left = right;
//             }
//             if(right - left + 1 == k){
//                 res++;
//                 left++;
//             }
//         }
//         return res;
        
//     }
// }

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0;
        int left = 0;

        for (int right = 1; right < n + k - 1; right++) { // for circular array k-1 add

            if (colors[right % n] == colors[(right - 1) % n]) {
                left = right;
            }

            if (right - left + 1 >= k) {
                res++;
            }
        }

        return res;
    }
}
