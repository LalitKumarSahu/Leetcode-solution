class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character>set = new HashSet<>();

        for(char ch : s.toCharArray()){  // O(N)
            set.add(ch);
        }
        int count = 0;  
        for(char ch : set){ // 26
            int first = -1;
            int last = -1;
            for(int i = 0; i<s.length(); i++){ //N
                if(ch == s.charAt(i)){
                if(first == -1){ // its a first occurence
                first = i;
                }
                last  = i;

                } 
            
            }
            if(first == last) continue; // only one char
            
            HashSet<Character>set1 = new HashSet<>();
            for(int i = first+1; i<last; i++){
            set1.add(s.charAt(i));
            }
            count += set1.size();
        }
       return count;


    }
}