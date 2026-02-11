class Solution {
    public int minimumRecolors(String blocks, int k) {
        // first window
        int w = 0;
        for(int i = 0; i<k; i++){
             if(blocks.charAt(i) == 'W')w++;
        }

        // next window
        int res = w;
        int n = blocks.length();

        for(int i = 1; i<(n-k+1); i++){

            // delete from start
            if(blocks.charAt(i-1) == 'W') w--;

            // add
            if(blocks.charAt(i + k -1) == 'W')w++;

            res = Math.min(res, w);
        }
        return res;
    }
}