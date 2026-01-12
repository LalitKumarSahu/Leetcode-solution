public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
  class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {

        String words[] = sentence.split(" ");
        int n = words.length;  // ✅ yaha fix
        int m = searchWord.length();

        for(int i = 0; i < n; i++){
            if(words[i].length() >= m){
                if(words[i].substring(0, m).equals(searchWord)){
                    return i + 1; // 1-based index
                }
            }
        }
        return -1;
    }
}

// m-2 without using split and substring
class Solution2 {
    public int isPrefixOfWord2(String sentence, String searchWord) {
        int n = sentence.length();
        int m = searchWord.length();
        int i = 0;
        int j = 0;
        int idx = 1;

        while (i < n) {

            // skip leading spaces
            while (i < n && sentence.charAt(i) == ' ') {
                i++;
            }

            // compare word with searchWord
            j = 0;
            int start = i;
            while (i < n && j < m && sentence.charAt(i) == searchWord.charAt(j)) {
                i++;
                j++;
            }

            // if full searchWord matched
            if (j == m) {
                return idx;
            }

            // move to end of current word
            while (i < n && sentence.charAt(i) != ' ') {
                i++;
            }

            // move to next word
            idx++;
        }

        return -1;
    }
}
}
