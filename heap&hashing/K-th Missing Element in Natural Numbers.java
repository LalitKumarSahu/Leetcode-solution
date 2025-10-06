class Solution {
    public int findKthSmall(int[] arr, int k) {
        int n = arr.length;

        // step 1: find max element
        int maxVal = Integer.MIN_VALUE;
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
        }

        // step 2: put all elements in set
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // step 3: find missing elements
        List<Integer> missList = new ArrayList<>();
        for (int i = 1; i < maxVal; i++) {
            if (!set.contains(i)) {
                missList.add(i);
            }
        }

        // step 4: return k-th missing
        if (missList.size() >= k) {
            return missList.get(k - 1);
        } else {
            return maxVal + (k - missList.size());
        }
    }
}
