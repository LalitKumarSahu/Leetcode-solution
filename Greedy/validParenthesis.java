public class validParenthesis {
    // tc:O(N) + O(N/2), sc:O(N)
    public boolean checkValidString(String s) {
        Stack<Integer> extraOpenBracket = new Stack<>();
        Stack<Integer> aestrick = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                extraOpenBracket.push(i);
            } 
            else if (ch == '*') {
                aestrick.push(i); // '*' ka index store karna jaruri hai
            } 
            else { // ch == ')'
                if (!extraOpenBracket.isEmpty()) {
                    extraOpenBracket.pop();
                } 
                else if (!aestrick.isEmpty()) {
                    aestrick.pop(); // '*' treated as '('
                } 
                else {
                    return false; // invalid closing bracket
                }
            }
        }

        // Match remaining '(' with '*' which come after them
        while (!extraOpenBracket.isEmpty()) {
            if (aestrick.isEmpty()) return false;
            if (extraOpenBracket.pop() > aestrick.pop()) return false;
        }

        return true;
    }
}
}
