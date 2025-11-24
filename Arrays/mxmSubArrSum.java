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

// Print Maximum Subarray
public class MaxSubArrayWithPrint {

    public static void maxSubArray(int arr[]) {
        int n = arr.length;

        int currSum = arr[0];
        int maxSum = arr[0];

        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < n; i++) {

            // if current element is better than extending previous sum
            if (arr[i] > currSum + arr[i]) {
                currSum = arr[i];
                tempStart = i;
            } else {
                currSum = currSum + arr[i];
            }

            // update maxSum and indexes
            if (currSum > maxSum) {
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }

        // Print results
        System.out.println("Maximum Subarray Sum = " + maxSum);
        System.out.print("Subarray = [ ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}

