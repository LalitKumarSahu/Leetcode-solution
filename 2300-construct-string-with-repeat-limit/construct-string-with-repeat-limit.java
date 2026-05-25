class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {

        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        int idx = 25;

        while(idx >= 0) {

            // current largest character nahi hai
            if(freq[idx] == 0) {
                idx--;
                continue;
            }

            // kitne use kar sakte hain
            int use = Math.min(freq[idx], repeatLimit);

            for(int i = 0; i < use; i++) {
                sb.append((char)('a' + idx));
            }

            freq[idx] -= use;

            // agar aur same char bacha hai
            if(freq[idx] > 0) {

                int next = idx - 1;

                // next smaller character find karo
                while(next >= 0 && freq[next] == 0) {
                    next--;
                }

                // koi smaller character hi nahi mila
                if(next < 0) {
                    break;
                }

                // ek smaller char add karo
                sb.append((char)('a' + next));
                freq[next]--;
            }
        }

        return sb.toString();
    }
}