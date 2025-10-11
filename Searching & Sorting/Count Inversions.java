class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        int n = arr.length;
        
        int count = 0;
        for(int i = 0; i<n-1; i++){
            
            for(int j = i+1; j<n;j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}

// m-2 optimal
class Solution {
    static long inversionCount(int arr[]) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }

    static long mergeSort(int arr[], int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }

    static long merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int temp[] = new int[high - low + 1];
        int k = 0;
        long count = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (mid - left + 1); // inversion count
            }
        }

        while (left <= mid) temp[k++] = arr[left++];
        while (right <= high) temp[k++] = arr[right++];

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }

        return count;
    }

    // for quick testing
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr)); // Output: 3
    }
}

