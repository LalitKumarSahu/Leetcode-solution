class Solution {
    // tc:O(N) + O(K) = O(N+K)
    public String reversePrefix(String word, char ch) {
        Stack<Character>s = new Stack<>();
        // String res = "";
        StringBuilder res = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            char currChar = word.charAt(i);
            s.push(currChar);

            if(currChar == ch){
                while(!s.isEmpty()){
                    //res = res + s.pop();
                    res.append(s.pop());
                }
               // res = res + word.substring(i+1, word.length());
               //return res;
               res.append(word.substring(i+1, word.length()));
              return res.toString();
            }
        }
        // ch does not exist in the map
        return word;
    }
}

//m-2 insert 0th idx util ch is not equal to word of i
class Solution {
    // tc:O(N)  = O(N)
    public String reversePrefix(String word, char ch) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char currChar = word.charAt(i);
            res.insert(0, currChar);

            if(currChar == ch){
               res.append(word.substring(i+1, word.length()));
              return res.toString();
            }
        }
        // ch does not exist in the map
        return word;
    }
}

//m-3 by using arr and swap
class Solution {
    public String reversePrefix(String word, char ch) {
        char res[] = word.toCharArray();
        int left = 0;
        for (int right = 0; right < word.length(); right++) {
            char currChar = res[right];
            if (currChar == ch) {
                while (left < right) {
                    char temp = res[left];
                    res[left] = res[right];
                    res[right] = temp;
                    left++;
                    right--;
                }
                return new String(res);
            }
        }

        return word;
    }
}





