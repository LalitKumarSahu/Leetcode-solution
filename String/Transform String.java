// User function Template for Java

class Solution {
    int transform(String A, String B) {
        int n = A.length();

        // Step 1: length check
        if (A.length() != B.length()) {
            return -1;
        }

        // Step 2: frequency check
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = A.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            char ch = B.charAt(i);
            if (!map.containsKey(ch)) return -1;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }
        if (map.size() != 0) return -1;

        // Step 3: count operations
        int i = n - 1;
        int j = n - 1;
        int operation = 0;

        while (i >= 0) {
            if (A.charAt(i) == B.charAt(j)) {
                // match mila → dono move
                i--;
                j--;
            } else {
                // mismatch → is character ko front le jana padega
                operation++;
                i--; // sirf i move hoga
            }
        }
        return operation;
    }
}
