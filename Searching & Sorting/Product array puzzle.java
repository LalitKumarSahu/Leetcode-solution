// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int res[] = new int[n];
        Arrays.fill(res, 1);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                
                if(i != j){
                    res[i] *= arr[j];
                }
            }
        }
        return res;
        
    }
}

// m-2 better approach
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int prefProd[] = new int[n];
        int suffProd[] = new int[n];
        int res[] = new int[n];

        // prefix product
        prefProd[0] = 1;
        for (int i = 1; i < n; i++) {
            prefProd[i] = arr[i - 1] * prefProd[i - 1];
        }

        // suffix product
        suffProd[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            suffProd[j] = arr[j + 1] * suffProd[j + 1];
        }

        // result = prefix * suffix
        for (int i = 0; i < n; i++) {
            res[i] = prefProd[i] * suffProd[i];
        }

        return res;
    }

    
    
}

// m-3 optimal approach

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        
        // Step 1: Calculate prefix products directly into res[]
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * arr[i - 1];
        }

        // Step 2: Multiply by suffix product on the fly
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix *= arr[i];
        }

        return res;
    }

    // for quick test
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        int ans[] = productExceptSelf(arr);
        for (int x : ans) System.out.print(x + " "); // Output: 24 12 8 6
    }
}

