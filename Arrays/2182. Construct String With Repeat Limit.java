class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {  // N
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int idx = 25; // largest char index

        while (idx >= 0) { //N
            if (freq[idx] == 0) {
                idx--;
                continue;
            }

            int use = Math.min(freq[idx], repeatLimit);
            for (int k = 0; k < use; k++) {
                sb.append((char) ('a' + idx));
            }
            freq[idx] -= use;

            if (freq[idx] > 0) {
                // find next smaller char
                int prevIdx = idx - 1;
                while (prevIdx >= 0 && freq[prevIdx] == 0) { // N
                    prevIdx--;
                }
                if (prevIdx < 0) {
                    break; // no smaller char, stop
                }
                sb.append((char) ('a' + prevIdx));
                freq[prevIdx]--;
            }
        }

        return sb.toString();
    }
}
