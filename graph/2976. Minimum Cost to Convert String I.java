class Solution {
    // tc:O(N*M + k^3)
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int dist[][] = new int[26][26];
        for(int i= 0; i<26; i++){
          Arrays.fill(dist[i], Integer.MAX_VALUE);
          dist[i][i] = 0;
        }
    
    // original to changed find cost and fill into matrix
        for(int i=0; i<cost.length; i++){
            int start = original[i]-'a';
            int end = changed[i] - 'a';
            dist[start][end] = Math.min(dist[start][end], cost[i]);
        }

        // floyd warshall algo
        for(int k=0; k<26; k++){
            for(int i = 0; i<26; i++){
                if(dist[i][k] < Integer.MAX_VALUE){
                    for(int j=0; j<26; j++){
                        if(dist[k][j] < Integer.MAX_VALUE){
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        } 

            long ans = 0;
            for(int i = 0; i<source.length(); i++){
                int c1 = source.charAt(i)-'a';
                int c2 = target.charAt(i)-'a';

                if(dist[c1][c2] == Integer.MAX_VALUE){
                    return -1;
                }else{
                    ans += (long)dist[c1][c2];
                }
            }
            return ans;
        
        
    }
}