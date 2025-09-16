class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int m = brokenLetters.length();
        int n = text.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            char ch = brokenLetters.charAt(i);
            set.add(ch);
        }

        boolean type = true;
        int totalType = 0;
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            if (set.contains(ch)) {
                type = false;
            } else if (ch == ' ' || i == n - 1) {
                if (type == true) {
                    totalType++;
                }
                type = true;
            }

        }
        return totalType;

    }
}