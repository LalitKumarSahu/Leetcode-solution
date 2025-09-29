class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();

        if( n < k){
            return false;
        }
        if(k == n){   // single single char ka palindrome
            return true;
        }

        int freq[] = new int[26];
        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }
        int oddCount = 0;
        for(int i=0; i<26; i++){
            if(freq[i] % 2 != 0){  // by using bitM- to check odd or not (freq[i] & 1 == 1) -- odd
                oddCount++;
            }
        }
        return (oddCount <= k);

    }
}