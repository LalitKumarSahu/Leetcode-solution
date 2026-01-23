
import java.util.Stack;
public class infixToPrefix {

// s:1 reverse the infix also in reverse (->), )->( opening ko closing and closing to opening
// s:2 infix to postfix
// s:3 reverse the answer
class Solution {

    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    static String reverseAndSwap(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') sb.append(')');
            else if (ch == ')') sb.append('(');
            else sb.append(ch);
        }
        return sb.toString();
    }

    static String infixToPostfixForPrefix(String s) {

        Stack<Character> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Operand
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {

                ans += ch;
            }

            else if (ch == '(') {
                st.push(ch);
            }

            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop();
            }

            // Operator (⚠️ PREFIX RULE)
            else {
                while (!st.isEmpty() &&
                      (precedence(st.peek()) > precedence(ch) ||
                      (precedence(st.peek()) == precedence(ch) && ch == '^'))) {

                    ans += st.pop();
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    // ⭐ MAIN FUNCTION
    public static String infixToPrefix(String s) {

        String rev = reverseAndSwap(s);
        String postfix = infixToPostfixForPrefix(rev);
        return new StringBuilder(postfix).reverse().toString();
    }
}

}
