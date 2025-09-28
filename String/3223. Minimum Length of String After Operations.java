class Solution {
    //abcccba // tc - O(n+26)
    public int minimumLength(String s) {

        HashMap<Character, Integer>map = new HashMap<>(); // key, value
        int n = s.length();
        
      // O(N)
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1); // O(1)
        }
        int count = 0;
        for(int f: map.values()){
            if(f % 2 == 0){
                count += 2;
            }else{
                count += 1;
            }
        }

        
       
       return count;
    }
}