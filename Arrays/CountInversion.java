public class CountInversion {
   // Brute force
    public long numberOfInversions1(int[] nums) {
           int n = nums.length;
            int count = 0;
           for(int i = 0; i<n; i++){
             for(int j = i+1; j<n; j++){
                if( nums[i] > nums[j])count++;
             }
           }
           return count;
    }

    // optimal soln
   public long numberOfInversions2(int[] nums) {
    int n = nums.length;
    return mergeSort(nums, 0, n - 1);
}

public long mergeSort(int arr[], int low, int high) {

    if (low >= high) return 0;

    int mid = low + (high - low) / 2;

    long count = 0;

    count += mergeSort(arr, low, mid);
    count += mergeSort(arr, mid + 1, high);

    count += countNumberOfInversion(arr, low, mid, high);

    merge(arr, low, mid, high);

    return count;
}

public long countNumberOfInversion(int arr[], int low, int mid, int high) {

    long count = 0;
    int right = mid + 1;

    for (int i = low; i <= mid; i++) {

        while (right <= high && arr[i] > arr[right]) {
            right++;
        }

        count += (right - (mid + 1));
    }

    return count;
}

public void merge(int arr[], int low, int mid, int high) {

    int temp[] = new int[high - low + 1];
    int left = low, right = mid + 1, idx = 0;

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp[idx++] = arr[left++];
        } else {
            temp[idx++] = arr[right++];
        }
    }

    while (left <= mid) temp[idx++] = arr[left++];
    while (right <= high) temp[idx++] = arr[right++];

    for (int i = low; i <= high; i++) {
        arr[i] = temp[i - low];
    }
}
}
