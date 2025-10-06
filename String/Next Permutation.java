class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        
        // Step 1: Find first decreasing element from right
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        // Step 2: If found, find the next greater element from right
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        
        // Step 3: Reverse the suffix
        rev(arr, i + 1, n - 1);
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void rev(int arr[], int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
