public class CountReversePairs {
  // Brute force
  public int countRevPairs1(int[] arr) {
      int n = arr.length;
      int count = 0;
      for(int i = 0; i<n; i++){
          
          for(int j = i+1; j<n; j++){
              
              if(arr[i] > 2 * arr[j]){
                  count++;
              }
          }
      }
      return count;
      
        
    }

    // m-2 optimal soln
    // optimal approach

   public int countRevPairs2(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;

        int count = mergeSort(arr, low, mid)
                  + mergeSort(arr, mid + 1, high);

        count += countPairs(arr, low, mid, high);

        merge(arr, low, mid, high);

        return count;
    }

    private int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }

        return count;
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

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
