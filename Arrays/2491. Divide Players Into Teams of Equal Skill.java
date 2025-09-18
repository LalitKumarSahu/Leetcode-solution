class Solution {
    public long dividePlayers(int[] skill) {
       int n = skill.length;
       int team = n/2;
       int totalSum = 0;
       long res = 0;
       HashMap<Integer, Integer>map = new HashMap<>();
       for(int elm : skill){
        map.put(elm , map.getOrDefault(elm, 0) +1);
        totalSum += elm;
       }
       if(totalSum % team != 0) return -1;

       int targetSum = totalSum / team;

       for(int elm : skill){
        if(map.get(elm) == 0) continue; // already taken

        map.put(elm, map.get(elm)-1);
        int partner = targetSum  - elm;

        if(!map.containsKey(partner) || map.get(partner) == 0) return -1;
        
        map.put(partner, map.get(partner)-1);

        res = res + (long)elm * (long)partner;
       }
       return res;
    }
}