public class RodCutting {
  //price[] = [1, 5, 8, 9, 10, 17, 17, 20] , N = 8
//first cut rod of length 2 , 2 idx ka price = 5
//and second cut the rod of length 6, 6th idx ka price = 17
// o/p = 5 + 17 = 22
// it is also infinite supply 1 length ka 8 bar kat sakte hai
class Solution {
    public int cutRod(int[] price) {
        int N = price.length; // N is the length of rod
        return rec(N, N-1, price);
    }
    public int rec(int N, int idx, int price[]){
        // base case : length of rod is one
        if(idx == 0){
            return N * price[idx];
        }
        int pick = 0;
        int currLen = idx+1;
        if(N >= currLen){
            pick = price[idx] + rec(N-currLen, idx, price);
        }
        int noPick = 0 + rec(N, idx-1, price);
        
        return Math.max(pick, noPick);
        
    }
}
}
