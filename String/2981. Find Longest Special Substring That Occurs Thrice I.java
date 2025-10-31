class Solution {
    public int maximumLength(String s) {
        
        HashMap<String, Integer>map = new HashMap<>();
        int n = s.length();

        for(int i = 0; i<n; i++){
            StringBuilder currStr = new StringBuilder();
            for(int j= i; j<n; j++){
                if(currStr.length() == 0 || s.charAt(j) == currStr.charAt(currStr.length() - 1)){
                    currStr.append(s.charAt(j));
                    String curr = currStr.toString();
                    map.put(curr, map.getOrDefault(curr,  0) + 1);
                }else{
                    break;
                }
            }
        }

        int maxLen = -1;

        for(String key : map.keySet()){
            int freq = map.get(key);
            if(freq > 2){
                maxLen = Math.max(maxLen, key.length());
            }
        }
        return maxLen;
    }
}