public class Alternating Groups II {
  class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0;
        int left = 0;

        for (int right = 1; right < n + k - 1; right++) { // for circular array k-1 add

            // skip entire subArray
            if (colors[right % n] == colors[(right - 1) % n]) {
                left = right;
            }

            if (right - left + 1 >= k) {
                res++;
            }
        }

        return res;
    }
}

}
