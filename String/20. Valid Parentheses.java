class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            // Opening brackets
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } 
            // Closing brackets
            else {
                if(st.isEmpty()) return false;  // stack khali hai, but closing mila

                if(
                   (st.peek() == '(' && ch == ')') || 
                   (st.peek() == '{' && ch == '}') ||
                   (st.peek() == '[' && ch == ']')
                ){
                    st.pop(); // matching hua
                } else {
                    return false; // mismatch mila
                }
            }
        }
        
        // Agar stack empty hai → valid
        return st.isEmpty();
    }
}
