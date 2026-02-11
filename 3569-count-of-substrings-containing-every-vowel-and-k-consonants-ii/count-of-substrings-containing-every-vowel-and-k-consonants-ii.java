class Solution {
    // return the count of substring which is at least all vowel and k constant
    public long countOfSubstrings(String word, int k) {
        return atLeast(word, k)  - atLeast(word, k+1);

    }
    private boolean isConstant(char ch){
        return(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
    }
    private boolean isAllVowelPresent(int freq[]){
        return(freq['a'-'a'] > 0 &&  freq['e'-'a'] > 0 && freq['i'-'a'] > 0 && freq['o'-'a'] > 0 && freq['u'-'a'] > 0);
    }
    public long atLeast(String words, int k){
        int freq[] = new int[26];
        long count = 0;
        int currConstant = 0;
        int n = words.length();
        int left = 0;
        for(int right = 0; right < n; right++){
            // expanding phase
            char ch = words.charAt(right);
            if(isConstant(ch)){
                currConstant++;
            }
            freq[ch - 'a']++;

            // shrinking
            while(currConstant >= k && isAllVowelPresent(freq)){
                count += (n - right);
                char c = words.charAt(left);
                if(isConstant(c)){
                    currConstant--;
                }
                freq[c - 'a']--;
                left++;
            }
        }
        return count;
    }
}