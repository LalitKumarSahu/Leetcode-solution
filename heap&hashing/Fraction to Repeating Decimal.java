import java.util.*;

class Solution {
    public String calculateFraction(int a, int b) {
        if (a == 0) return "0"; // numerator 0 → result 0

        StringBuilder sb = new StringBuilder();

        // handle negative sign
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            sb.append("-");
        }

        long num = Math.abs((long)a);
        long den = Math.abs((long)b);

        // integer part
        long integerPart = num / den;
        sb.append(integerPart);

        long rem = num % den;
        if (rem == 0) return sb.toString(); // exact division

        sb.append(".");

        // Map remainder → index where its quotient digit starts
        HashMap<Long, Integer> map = new HashMap<>();

        while (rem != 0) {
            if (map.containsKey(rem)) {
                int idx = map.get(rem);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }

            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem %= den;
        }

        return sb.toString();
    }
}
