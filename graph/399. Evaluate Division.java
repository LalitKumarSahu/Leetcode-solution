import java.util.*;

class Solution {
    public double dfs(String src, String target, double prod, HashSet<String> visited, 
        HashMap<String, HashMap<String, Double>> hm) {

        double ret = -1.0;
        
        visited.add(src);

        if (hm.get(src).containsKey(target)) {
            ret = hm.get(src).get(target) * prod;
        } else {
            for (String neighbor : hm.get(src).keySet()) {
                if (!visited.contains(neighbor)) {
                    ret = dfs(neighbor, target, prod * hm.get(src).get(neighbor), visited, hm);
                    if (ret != -1.0) {
                        break;
                    }
                }
            }
        }

        visited.remove(src);
        return ret;
    }
    // tc-O(M) + k * N --m for detecting a graph k-every query dfs call
    //sc- O(N) + O(N)--rec+stack for dfs and map

public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       
        // Graph representation using adjacency list
        HashMap<String, HashMap<String, Double>>hm = new HashMap<>();

        for(int i=0; i<equations.size(); i++){
            String divedent = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            Double res = values[i];

            if(!hm.containsKey(divedent)){
                hm.put(divedent, new HashMap<String, Double>());
            }
            if(!hm.containsKey(divisor)){
                hm.put(divisor, new HashMap<String, Double>());
            }

            hm.get(divedent).put(divisor, res);
            hm.get(divisor).put(divedent, 1/res);


        }
        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String divedent = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if(!hm.containsKey(divedent) || !hm.containsKey(divisor)){
             res[i] = -1.0;
            }else if(divedent.equals(divisor)){
                res[i] = 1.0;
            }else{
               HashSet<String>vis = new HashSet<>();
               res[i] = dfs(divedent, divisor, 1, vis, hm);
            }
        }
         
       return res;


       
    }
}
