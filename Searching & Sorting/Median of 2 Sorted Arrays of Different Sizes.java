import java.util.*;

class Solution {
    public double medianOf2(int a[], int b[]) {
        int n1 = a.length, n2 = b.length;
        int arr[] = new int[n1 + n2];

        int i = 0;
        while (i < n1) {
            arr[i] = a[i];
            i++;
        }

        int j = 0;
        while (j < n2) {
            arr[j + n1] = b[j];
            j++;
        }

        Arrays.sort(arr);

        int m = n1 + n2;

        // odd length → middle element
        if (m % 2 != 0) {
            return arr[m / 2];
        } 
        // even length → average of two middle elements
        else {
            return (arr[(m / 2) - 1] + arr[m / 2]) / 2.0;
        }
    }
}
