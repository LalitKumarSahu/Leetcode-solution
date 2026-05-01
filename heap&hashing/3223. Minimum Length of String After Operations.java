import java.util.HashMap;
public class 3223. Minimum Length of String After Operations {
  class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        int n = s.length();
        int count = 0;
        for(int i =0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int val : map.values()){
            if(val % 2 == 0){
                count += 2;
            }else{
                count += 1;
            }
        }
        return count;
    }
}

class Solution2 {
    public int minimumLength(String s) {
        // HashMap<Character,Integer>map = new HashMap<>();
        int freq[] = new int[26];
        int n = s.length();
        int count = 0;
        for(int i =0; i<n; i++){
            char ch = s.charAt(i);
             freq[ch-'a']++;
        }
        for(int i = 0; i<26; i++){
            if(freq[i] != 0){
                if(freq[i] % 2 == 0){
                    count += 2;
                }else{
                    count += 1;
                }
            }
        }
        return count;
    }
}
}
