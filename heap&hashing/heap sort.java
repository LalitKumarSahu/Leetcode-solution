public class heap sort {

  public static void heapify(int arr[], int idx, int size){
    int largest = idx;
    int left = 2*idx + 1;
    int right = 2*idx + 2;

    if(left < size && arr[left] > arr[largest]){
      largest = left;
    }
    if(right < size && arr[right] > arr[largest]){
      largest = right;
    }

    if(largest != idx){
      int temp = arr[largest];
      arr[largest] = arr[idx];
      arr[idx] = temp;
      heapify(arr, largest, size);
    }
  }

  public static void HeapSort(int arr[]){
     int n = arr.length;
    // build max-heap
    for(int i = n/2; i>=0; i--){
      heapify(arr,i, n); // idx and size
    }

    // push largest to end
    for(int i = n-1; i>0; i--){
     int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr,0, i); // idx and size
    }

  }
  
}
