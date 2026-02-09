import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int csf[] = new int[26];

        String firstWord = words[0];
        
        for(char ch : firstWord.toCharArray()){
            int idx = ch - 'a';
            csf[idx]++;
        }

        int n = words.length;
        for(int i = 1; i < n; i++){
            int curr[] = new int[26];
            String currWord = words[i];
            for(char ch : currWord.toCharArray()){
                int idx = ch - 'a';
                curr[idx]++;
            }

            // Update csf with min values
            for(int j = 0; j < 26; j++){
                csf[j] = Math.min(csf[j], curr[j]);
            }
        }

        List<String> res = new ArrayList<>();
        for(int j = 0; j < 26; j++){
            if(csf[j] != 0){
                char ch = (char)(j + 'a');
                int count = csf[j];

                while(count > 0){
                    res.add(String.valueOf(ch));  //// convert char to string 'a' = "a"
                    count--;
                }
            }
        }

        return res;
    }
}




