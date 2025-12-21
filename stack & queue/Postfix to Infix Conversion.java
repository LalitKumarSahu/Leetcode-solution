  import java.util.Stack;
public class Postfix to Infix Conversion {


class Solution {

    // ⚠️ Method name SAME as driver code
    public static String postToInfix(String s) {

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

                String expr = "(" + op1 + ch + op2 + ")";
                st.push(expr);
            }
        }

        return st.peek();
    }
}

}
