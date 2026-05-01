import java.util.*;
public class 1930. Unique Length-3 Palindromic Subsequences {
  class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character>set = new HashSet<>();
       
        int count = 0;

        for(char ch : s.toCharArray()){
            set.add(ch);
        }
        for(char ch : set){
             int first = -1;
             int last = -1;
            for(int i = 0; i<s.length(); i++){
                if(ch == s.charAt(i)){
                    if(first == -1){
                        first = i;
                    }
                    last = i;
                }
            }
            if(first == last) continue;
             HashSet<Character>set1 = new HashSet<>();
             for(int i = first+1; i<last; i++){
                set1.add(s.charAt(i));
             }
             count += set1.size();

        }
        return count;

        
    }

    // m-2 optimization
    public int countPalindromicSubsequence2(String s) {
       HashMap<Character,Integer>firstOcc = new HashMap<>();
       HashMap<Character,Integer>lastOcc = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!firstOcc.containsKey(ch)){
                firstOcc.put(ch, i);
            }
            lastOcc.put(ch, i);
        }
        
        int count = 0;
        for (char ch : firstOcc.keySet()) { // 26
            int first = firstOcc.get(ch);
            int last = lastOcc.get(ch);
           
            if (first == last)
                continue; // only one char

            HashSet<Character> set1 = new HashSet<>();
            for (int i = first + 1; i < last; i++) {
                set1.add(s.charAt(i));
            }
            count += set1.size();
        }
        return count;

    }

}
