  class Solution {
    public String fractionAddition(String expression) {
        int num = 0;  // numerator
        int den = 1;  // denominator

        int n = expression.length();
        int i = 0;

        while (i < n) {
            int currNum = 0;
            int currDen = 0;
            boolean isNeg = false;

            // check + or -
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                if (expression.charAt(i) == '-') {
                    isNeg = true;
                }
                i++;
            }

            // parse numerator
            int start = i;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            currNum = Integer.parseInt(expression.substring(start, i));
            if (isNeg) currNum *= -1;

            // skip '/'
            i++;

            // parse denominator
            start = i;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            currDen = Integer.parseInt(expression.substring(start, i));

            // combine fraction with result
            num = num * currDen + den * currNum;
            den = den * currDen;

            // reduce fraction jo bhi gcd number aayega usi se dono ko devide kar denge
            int gcdStep = gcd(Math.abs(num), den);
            num /= gcdStep;
            den /= gcdStep;
        }

        return num + "/" + den;
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
