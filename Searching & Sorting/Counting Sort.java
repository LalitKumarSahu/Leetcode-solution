class Solution {
    public static String countSort(String s) {
        // Step 1: Frequency array banao for 'a' to 'z'
        int[] freq = new int[26];
        
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Sorted string banao
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                sb.append((char)(i + 'a'));
                freq[i]--;
            }
        }

        return sb.toString();
    }
}
