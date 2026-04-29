public class 1545. Find Kth Bit in Nth Binary String {
  
// reverse(invert(Si - 1)) = isme first val ka flip last ban jata hai 2nd ka 2nd last and so on
//011 = 011 1 001 agar hame 7th idx pata karna hai kya hai = len - k + 1 = 7-7+1 = 0 iska flip = 1
// aise nikalte hai right me hai to 
class Solution {
    public char findKthBit(int n, int k) {
        int len = (int)Math.pow(2, n)-1;
        return rec(len, k);
    }
    public char rec(int len, int k){
        //base case
        if(len == 1){
            return '0';
        }
        int half = len/2;
        int middle = half + 1;

        if(k == middle){
            return '1';
        }else if(k < middle){ // left half
            return rec(half, k);
        }else{ // right
          char ans = rec(half, 1 + len - k);

         return(ans == '0')?'1':'0';

        }
    }
}
}
