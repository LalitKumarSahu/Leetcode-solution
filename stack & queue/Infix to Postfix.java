import java.util.Stack;

public class Infix to Postfix {

class Solution {

    // Function to return precedence of operators
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1;
    }

    public static String infixToPostfix(String s) {

        Stack<Character> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 1️⃣ If operand, add to answer
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {

                ans += ch;
            }

            // 2️⃣ If opening bracket, push to stack
            else if (ch == '(') {
                st.push(ch);
            }

            // 3️⃣ If closing bracket
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop(); // remove '('
            }

            // 4️⃣ If operator
            // stack ke peek ka opeartor less hai ch se to stack me dal denge
            // agr less than hai to stack se pop karnge peek vala ans me add kar denge aur curr ch ko stack me dal denge
            else {
                while (!st.isEmpty() &&
                      (precedence(st.peek()) > precedence(ch) ||
                      (precedence(st.peek()) == precedence(ch) && ch != '^'))) {
                    ans += st.pop();
                }
                st.push(ch);
            }
        }

        // 5️⃣ Pop remaining operators
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}

}
