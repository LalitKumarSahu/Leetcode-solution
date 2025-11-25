public class Rotate by 90 degree {
  class GFG {
    
    // Brute force , tc : O(N^2), sc : O(N^2)
    static void rotate(int mat[][]) {
        int n = mat.length;

        int ans[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = mat[i][j];
            }
        }

        // Copy ans back into mat[][]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ans[i][j];
            }
        }
    }
    
    // optimal soln , 1:transpose(row to col), 2:rev the row
     static void rotate2(int mat[][]) {
        int n = mat.length;

       // 1. Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

         // 2. Reverse each row
        for (int i = 0; i < n; i++) {
           int left = 0, right = n-1;
           while(left < right){
               int temp = mat[i][left];
               mat[i][left] = mat[i][right];
               mat[i][right] = temp;
               left++;
               right--;
           }
        }
    }
}

}
