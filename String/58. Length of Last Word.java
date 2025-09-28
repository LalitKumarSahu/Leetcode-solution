class Solution {
    // tc:O(N)--sc:O(1)
    public int lengthOfLastWord(String s) {
    int i = s.length()-1;
    while(i >= 0 && s.charAt(i) == ' '){
        i--;
    }
    int len = 0;
    while(i >= 0 && s.charAt(i) != ' '){
        len++;
        i--;
    }
    return len;

    }
}

// m-2 in a singel loop
class Solution {
    // tc:O(N)--sc:O(1)
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i) == ' '){
                if(len == 0){
                    i--;
                }else{
                    break;
                }
                
            }else{
                len++;
                 i--;
            }
        }
       
        return len;
    }
}
