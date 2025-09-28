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