  import java.util.Stack;
public class postfix to prefix {


class Solution {

    public static String postToPre(String s) {

        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Operand
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {

                st.push(String.valueOf(ch));
            }
            // Operator
            else {
                String op2 = st.pop();
                String op1 = st.pop();

                String expr = ch + op1 + op2;
                st.push(expr);
            }
        }

        return st.peek();
    }
}

}
