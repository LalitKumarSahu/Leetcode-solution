class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] map = new int[k];
        
        for (int elm : arr) { // n
            int rem = ((elm % k) + k) % k;
            map[rem]++;
        }
        
        // Check if count of remainder 0 is even
        if (map[0] % 2 != 0) return false;

        // Check other remainders
        for (int rem = 1; rem < k; rem++) {  // k/2
            int comp = k - rem;
            if (map[rem] != map[comp]) return false;
        }

        return true;
    }
}
