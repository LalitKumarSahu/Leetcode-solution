public class 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence {
  class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {

        String words[] = sentence.split(" "); // i, love,  eating, burger
        int n = words.length; 
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
