class Solution {
    public int[] getNoZeroIntegers(int n) {
        int i = 1;
        int j = n - 1;

        while (i <= j) {
            if (isNoZero(i) && isNoZero(j)) {
                return new int[]{i, j};
            }
            i++;
            j--;
        }

        return new int[]{}; // just in case (though problem guarantees answer)
    }

    public boolean isNoZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false; // agar digit 0 mila
            }
            n /= 10; // next digit
        }
        return true;
    }
}
