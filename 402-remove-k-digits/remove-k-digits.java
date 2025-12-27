class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        int n = num.length();

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            while (!s.isEmpty() && k > 0 && s.peek() > ch) {
                s.pop();
                k--;
            }
            s.push(ch);
        }

        // Agar k bacha ho
        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }

        if (s.isEmpty()) return "0";

        // Stack → String
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        sb.reverse();

        // Leading zeros remove
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
