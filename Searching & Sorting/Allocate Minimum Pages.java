class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1; // More students than books

        int sum = 0;
        int max = 0;
        for (int pages : arr) {
            sum += pages;
            max = Math.max(max, pages);
        }

        int start = max;  // minimum possible pages (no student can get less than the largest book)
        int end = sum;    // maximum possible pages (one student gets all books)
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(arr, n, k, mid)) {
                ans = mid;      // valid — try for smaller max
                end = mid - 1;
            } else {
                start = mid + 1; // invalid — need larger max
            }
        }

        return ans;
    }

    public boolean isValid(int[] arr, int n, int k, int maxAllowed) {
        int students = 1;
        int pages = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxAllowed) return false; // single book exceeds limit

            if (pages + arr[i] <= maxAllowed) {
                pages += arr[i];
            } else {
                students++;
                pages = arr[i];
                if (students > k) return false;
            }
        }

        return true;
    }
}
