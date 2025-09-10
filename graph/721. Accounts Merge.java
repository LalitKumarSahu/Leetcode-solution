class Solution {
    // tc-n * k + O(n*k + n*kLog n*K)--adj map + dfs+sort===O(N*K)log(N*K)
    //sc=n*K + n*k + O(n*k) ==creat map + rec stack + sort space
    public void dfs(String srcEmail, HashMap<String,List<String>>adjMap, HashSet<String>vis , List<String>subList ){
        vis.add(srcEmail);
        subList.add(srcEmail);
        if(!adjMap.containsKey(srcEmail)){
            return;
        }
        for(String neighbor : adjMap.get(srcEmail)){
            if(!vis.contains(neighbor)){
                dfs(neighbor, adjMap, vis, subList);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,List<String>>adjMap = new HashMap<>();

        for(List<String>account : accounts){
            String firstEmail = account.get(1);
            for(int i=2; i<account.size(); i++){
                String email = account.get(i);

               if(!adjMap.containsKey(firstEmail)){
                adjMap.put(firstEmail, new ArrayList<>());
               }
               adjMap.get(firstEmail).add(email);

                 
               if(!adjMap.containsKey(email)){
                adjMap.put(email, new ArrayList<>());
               }
               adjMap.get(email).add(firstEmail);
            }
           
        }

        List<List<String>>res = new ArrayList<>();
        
        HashSet<String>vis = new HashSet<>();
         for(List<String>account : accounts){
            String firstEmail = account.get(1);
            if(!vis.contains(firstEmail)){
                List<String>subList = new ArrayList<>();
                dfs(firstEmail, adjMap, vis, subList);
                Collections.sort(subList);
                subList.add(0, account.get(0));// add name at 1st idx
                res.add(subList);
            }
         }


        return res;
    }
}