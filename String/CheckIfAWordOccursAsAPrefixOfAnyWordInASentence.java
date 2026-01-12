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
}
