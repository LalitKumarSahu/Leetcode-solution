
class Solution {
    // tc-n-1 for creating adjList + O(N) dfs call
    // sc - n * n-1 for storing adjList + O(N) recursion stack
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>>adjList = new ArrayList<>();
        
        // initilize list
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int from = edge[0];
            int to = edge[1];

            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
       return dfs(0, -1, adjList, hasApple); // src, par, list, hasApple
        
    }
    public int dfs(int src, int par, List<List<Integer>>adjList, List<Boolean> hasApple){
        int totalTime = 0;

        for(int neighbour : adjList.get(src)){
          
            if(neighbour == par) continue;

            int timeTakenByChild = dfs(neighbour, src, adjList, hasApple);

            if(timeTakenByChild > 0 || hasApple.get(neighbour)){
                totalTime += timeTakenByChild + 2;
            }
        }
        return totalTime;
    }
}
