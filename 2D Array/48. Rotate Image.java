/*
transpose:      rev each row:
1 4 7           7 4 1
2 5 8  ------>  8 5 2 
3 6 9           9 6 3

*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // (transpose) -- swap mat[i][j] to mat[j][i] -- each row will be col
        for(int i = 0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse the each row right to left

        for(int i = 0; i<n; i++){
            int left = 0; int right = n-1;

            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
    }
}