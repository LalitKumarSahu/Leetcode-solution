  import java.util.Stack;

public class prefix to postfix {


class Solution {

    public static String preToPost(String s) {

        Stack<String> st = new Stack<>();

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // Operand
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {

                st.push(String.valueOf(ch));
            }
            // Operator
            else {
                String op1 = st.pop();
                String op2 = st.pop();

                String expr = op1 + op2 + ch;
                st.push(expr);
            }
        }

        return st.peek();
    }
}

}
