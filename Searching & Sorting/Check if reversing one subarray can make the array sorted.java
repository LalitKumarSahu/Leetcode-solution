class Solution {
    public static String checkReverse(int arr[]) {
        int n = arr.length;
        int i, j;

        // Step 1: find the first index where order breaks
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                break;
        }

        // if no break point found → array already sorted
        if (i == n - 1)
            return "Yes";

        // Step 2: find the last index where order breaks
        for (j = i; j < n - 1; j++) {
            if (arr[j] < arr[j + 1])
                break;
        }

        // Step 3: reverse subarray arr[i...j]
        reverse(arr, i, j);

        // Step 4: check if array is sorted now
        if (isSorted(arr))
            return "Yes";
        else
            return "No";
    }

    // helper to reverse a subarray in place
    private static void reverse(int arr[], int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    // helper to check if array is sorted
    private static boolean isSorted(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    // main to test
    public static void main(String[] args) {
        int arr1[] = {1, 2, 5, 4, 3};
        int arr2[] = {1, 2, 4, 5, 3};

        System.out.println(checkReverse(arr1)); // Yes
        System.out.println(checkReverse(arr2)); // No
    }
}
