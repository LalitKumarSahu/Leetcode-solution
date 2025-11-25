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
