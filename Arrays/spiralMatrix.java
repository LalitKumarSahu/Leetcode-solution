public class spiralMatrix {
    public static void spiralMat(int mat[][]) {
        int startRow = 0;
        int endRow = mat.length - 1;
        int startCol = 0;
        int endCol = mat[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // 1. Print Top Row
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(mat[startRow][j] + " ");
            }
            startRow++;

            // 2. Print Right Column
            for (int i = startRow; i <= endRow; i++) {
                System.out.print(mat[i][endCol] + " ");
            }
            endCol--;

            // 3. Print Bottom Row
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    System.out.print(mat[endRow][j] + " ");
                }
                endRow--;
            }

            // 4. Print Left Column
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    System.out.print(mat[i][startCol] + " ");
                }
                startCol++;
            }
        }
    }
}

// spiral matrix find kth

class Solution {

    public int findK(int a[][], int n, int m, int k) {
       int stR = 0;
       int stC = 0;
       int endR = n-1;
       int endC = m-1;
       
       int count = 0;
       while(stR <= endR && stC <= endC){
           for(int j = stC; j <= endC; j++){
               count++;
               if(count == k) return a[stR][j];
           }
           stR++;
           for(int i = stR; i<= endR; i++ ){
               count++;
               if(count == k) return a[i][endC];
           }
           endC--;
           if(stR <= endR){
           for(int j = endC; j >= stC; j--){
               count++;
               if(count == k) return a[endR][j];
            }
            endR--;
           }
           
           if(stC <= endC){
           for(int i = endR; i >= stR; i--){
               count++;
               if(count == k) return a[i][stC];
           }
           stC++;
           }
       }
       return -1;
    }
}