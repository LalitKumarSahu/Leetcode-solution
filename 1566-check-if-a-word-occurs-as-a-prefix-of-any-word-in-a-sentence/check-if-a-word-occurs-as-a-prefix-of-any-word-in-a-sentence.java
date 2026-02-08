// class Solution {
//     public int isPrefixOfWord(String sentence, String searchWord) {

//         String words[] = sentence.split(" "); // i, love,  eating, burger
//         int n = words.length; 
//         int m = searchWord.length();

//         for(int i = 0; i < n; i++){
//             if(words[i].length() >= m){
//                 if(words[i].substring(0, m).equals(searchWord)){
//                     return i + 1; // 1-based index
//                 }
//             }
//         }
//         return -1;
//     }
// }

// m-2 without using split and substring
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int n = sentence.length();
        int m = searchWord.length();
        int i = 0;
        int idx = 1;

        while (i < n) {

            // skip spaces
            while (i < n && sentence.charAt(i) == ' ') {
                i++;
            }

            int j = 0;
            int start = i;

            // match prefix
            while (i < n && j < m && sentence.charAt(i) == searchWord.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return idx;
            }

            // move i to end of current word
            while (i < n && sentence.charAt(i) != ' ') {
                i++;
            }

            idx++; // ✅ next word
        }

        return -1;
    }
}

