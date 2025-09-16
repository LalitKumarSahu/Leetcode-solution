import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            while (!list.isEmpty() && gcd(list.get(list.size() - 1), num) > 1) {
                int last = list.remove(list.size() - 1);
                num = lcm(last, num);
            }
            list.add(num);
        }

        return list;
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    private int lcm(int x, int y) {
        return x / gcd(x, y) * y;
    }
}
