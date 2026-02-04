public class MaxChunksToMakeArrSorted {
   public int maxChunksToSorted(int[] arr) {
        int maxVal = 0;
        int chunks = 0;

        for(int i=0; i<arr.length; i++){
            maxVal = Math.max(maxVal, arr[i]);
            if(maxVal == i){
                chunks++;
            }
        }
        return chunks;
        
    }
}
