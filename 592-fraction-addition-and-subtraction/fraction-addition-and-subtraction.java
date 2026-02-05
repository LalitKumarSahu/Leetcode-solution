// Time Complexity: O(n + log K)
// - n is the length of the input string (parsing all characters)
// - K is the maximum value of numerator or denominator (for GCD calculation)
// Space Complexity: O(1)
// - Constant extra space used for variables only.

// class Solution {
//     public String fractionAddition(String expression) {
//         int num = 0; // running numerator
//         int den = 1; // running denominator
//         int n = expression.length();
//         int i = 0;

//         while (i < n) {
//             int currNum = 0;
//             int currDen = 0;
//             boolean isNegative = false;

//             // Handle sign
//             if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
//                 if (expression.charAt(i) == '-') {
//                     isNegative = true;
//                 }
//                 i++; // skip the sign
//             }

//             // Parse numerator
//             int start = i;
//             while (i < n && Character.isDigit(expression.charAt(i))) {
//                 i++;
//             }
//             currNum = Integer.parseInt(expression.substring(start, i));
//             if (isNegative)
//                 currNum *= -1;

//             i++; // skip '/'

//             // Parse denominator
//             start = i;
//             while (i < n && Character.isDigit(expression.charAt(i))) {
//                 i++;
//             }
//             currDen = Integer.parseInt(expression.substring(start, i));

//             // Add current fraction to result
//             num = num * currDen + currNum * den;
//             den = den * currDen;

//             // Simplify after each addition (optional but cleaner)
//             int gcdStep = Math.abs(getGcd(num, den));
//             num /= gcdStep;
//             den /= gcdStep;
//         }

//         return num + "/" + den;
//     }

//     public int getGcd(int a, int b) {
//         if (a == 0)
//             return b;
//         return getGcd(b % a, a);
//     }
// }

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

            // reduce fraction
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
