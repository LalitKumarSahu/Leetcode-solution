class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer>ballMap = new HashMap<>();
        HashMap<Integer,Integer>colMap = new HashMap<>();

        int n = queries.length;
        int res[] = new int[n];

        for(int i = 0; i<n; i++){
            int ball = queries[i][0];
            int col = queries[i][1];

            if(!ballMap.containsKey(ball)){
                ballMap.put(ball,col);
                colMap.put(col, colMap.getOrDefault(col, 0) + 1);
            }else{
                int oldCol = ballMap.get(ball);
                colMap.put(oldCol, colMap.get(oldCol) - 1);
                if(colMap.get(oldCol) == 0){
                    colMap.remove(oldCol);
                }
                ballMap.put(ball, col); 
                colMap.put(col, colMap.getOrDefault(col, 0) + 1);    
            }
            res[i] = colMap.size();
        }
        return res;

    }
}