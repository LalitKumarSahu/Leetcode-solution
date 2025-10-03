import java.util.*;

class Solution {
    public static String smallestWindow(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);

        int unique = map.size();
        int ws = 0, we = 0, n = s.length();
        int startIdx = -1, minLen = Integer.MAX_VALUE;

        while (we < n) {
            //<------expanding------>
            char end = s.charAt(we);
            if (map.containsKey(end)) {
                map.put(end, map.get(end) - 1);
                if (map.get(end) == 0) unique--;
            }
            
            // <----shrinking------->
            while (unique == 0) {
                int len = we - ws + 1;
                if (len < minLen) {
                    minLen = len;
                    startIdx = ws;
                }

                char start = s.charAt(ws);
                if (map.containsKey(start)) {
                    map.put(start, map.get(start) + 1);
                    if (map.get(start) > 0) unique++;
                }
                ws++;
            }
            we++;
        }

        if (startIdx == -1) return ""; // <-- return empty string (not "-1")
        return s.substring(startIdx, startIdx + minLen);
    }
}
