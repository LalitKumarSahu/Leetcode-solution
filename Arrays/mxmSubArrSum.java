public class mxmSubArrSum {

    public static int maxSubArrSum(int arr[]) {
        int n = arr.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            currSum =  currSum + arr[i];
            if(currSum <  0) currSum = 0;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
// handle all negative arr

public class mxmSubArrSum {

    public static int maxSubArrSum(int arr[]) {
        int n = arr.length;

        int currSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
