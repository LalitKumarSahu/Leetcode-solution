
class Solution {
    //tc-O(N^2) for creating adjList + O(N) dfs call
    //sc-O(N^2) for storing adjList + O(N) recursion stack
      public void dfs(int src, List<List<Integer>>adjList, boolean vis[]){
       vis[src] = true;
       for(int neigh : adjList.get(src)){
         if(!vis[neigh]){
            dfs(neigh, adjList, vis);

         }
       }


    }
     public int removeStones(int[][] stones) {
        
      int n = stones.length;
      List<List<Integer>>adjList = new ArrayList<>();

      for(int i=0; i<n; i++){
        adjList.add(new ArrayList<>());
      }
      for(int i=0; i<n; i++){
        for(int j = i+1; j<n; j++){
            if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                adjList.get(i).add(j);
                adjList.get(j).add(i);

            }
        }
      }
      int component = 0;
      boolean vis[] = new boolean[n];
      for(int i =0; i<n; i++){
        if(!vis[i]){
            dfs(i, adjList, vis);
            component++;
        }
      }
      return n - component;
     }
}