import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
  
// ------Approach-1 ---tc-o(2N)-------sc-O(N)--->
class Solution {
    public int lengthOfLongestSubstring(String s) {
     int windowStart = 0;
     int windowEnd = 0;
     int n = s.length();
     int maxLen = Integer.MIN_VALUE;
     HashSet<Character>set = new HashSet<>();

     while(windowEnd < n){
        char ch = s.charAt(windowEnd);

      // shrinking phase
      if(set.contains(ch)){
          while( windowStart < windowEnd && set.contains(ch)){
            set.remove(s.charAt(windowStart));
            windowStart++;
        }
      }
      set.add(ch);
      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
      windowEnd++;
     }

     return (maxLen == Integer.MIN_VALUE? 0 : maxLen );
    }
}


// --------Approach-2---tc-o(N)-------sc-O(256)=O(1)---------->
class Solution {
    public int lengthOfLongestSubstring(String s) {
     int windowStart = 0;
     int windowEnd = 0;
     int n = s.length();
     int maxLen = Integer.MIN_VALUE;
    HashMap<Character, Integer>map = new HashMap<>();

     while(windowEnd < n){
        char ch = s.charAt(windowEnd);
    
    // shrinking phase
      if(map.containsKey(ch) && map.get(ch) >= windowStart){
          
        windowStart = map.get(ch) + 1;
      }
      map.put(ch, windowEnd);
      maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
      windowEnd++;
     }

     return (maxLen == Integer.MIN_VALUE? 0 : maxLen );
    }
}


/*
Time Complexity (TC)
Each character is processed at most twice: once when expanding windowEnd and once when windowStart moves forward.

The while loop runs O(n) times, where n is the length of the string.

Inside the loop:

map.containsKey(ch) and map.get(ch) operations take O(1) time (since HashMap operations are on average O(1)).

map.put(ch, windowEnd) takes O(1) time.

Math.max(...) also takes O(1) time.

Thus, the overall time complexity is O(n).

Space Complexity (SC)
The HashMap<Character, Integer> stores at most O(min(n, 256)) characters, where n is the input size.

Since the input consists of ASCII characters (at most 256 unique characters), the worst-case space complexity is O(256) = O(1).

Other variables (windowStart, windowEnd, maxLen, ch, n) take O(1) space.

Thus, the overall space complexity is O(min(n, 256)) ≈ O(1).
*/
}
