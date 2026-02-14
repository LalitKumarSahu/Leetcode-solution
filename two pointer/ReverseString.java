public class ReverseString {
  class Solution {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length;

        // Push all characters into the stack
        for (int i = 0; i < n; i++) {
            stack.push(s[i]);
        }

        // Pop and put them back into the array
        for (int i = 0; i < n; i++) {
            s[i] = stack.pop();
        }
    }
}

//m-2
class Solution {
    public void reverseString(char[] s) {
    StringBuilder reverse = new StringBuilder(new String(s)). reverse();
    for(int i=0; i<s.length; i++){
        s[i] = reverse.charAt(i);
    }
    }
}




}
