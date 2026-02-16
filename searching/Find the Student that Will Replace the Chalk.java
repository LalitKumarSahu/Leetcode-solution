public class Find the Student that Will Replace the Chalk {
  class Solution {
    public int chalkReplacer(int[] chalk, int k) {
      long totalSum = 0;
        for(int c : chalk){
            totalSum += c;
        }
        //Isse unnecessary full rounds remove ho jayenge.
         k = (int)(k % totalSum);
         int n = chalk.length;
         for(int i = 0; i<n; i++){
            if(k < chalk[i]){
                return i;
            }
            k -= chalk[i];
         }
         return -1;
    }
}
}
