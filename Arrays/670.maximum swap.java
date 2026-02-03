// -----Brute force m-1----
// find the max elm from the right side
// and then first elm se jo greater hoga use swap karke return kar denge
// ------m-2---------
// right se max dekenge uska idx store kar lenge
// fir start form 0th idx uska right me max pata hi hai usi se swap kar denge
// [3,4,7,1,5,3] = [7,7,7,5,5,3] inka idx->[2,2,2,4,4,5] ->3 ka max idx 2 = swap (3,7)

class Solution {
    public int maximumSwap(int num) {
        char numArr[] = Integer.toString(num).toCharArray();
        int n = numArr.length;
        char maxElm = numArr[n-1];
        int maxIdx = n-1;
        int swapIdx1 = -1;
        int swapIdx2 = -1;

        for(int i = n-2; i>=0; i--){
            if(numArr[i] > maxElm){
                maxElm = numArr[i];
                maxIdx = i;
            }else if(numArr[i] < maxElm){
                swapIdx1 = i;
                swapIdx2 = maxIdx;
            }
        }
        
        // perform swaping
        if(swapIdx1 != -1){
            char temp = numArr[swapIdx1];
            numArr[swapIdx1] = numArr[swapIdx2];
            numArr[swapIdx2] = temp;
        }
        return Integer.parseInt(new String(numArr));
    }
}